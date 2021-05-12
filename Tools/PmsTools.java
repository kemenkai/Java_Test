package com.yearcon.projectsystem.common.utils;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
@Slf4j
public class PmsTools {

    // 模板消息字体颜色
    private static final String TEMPLATE_FRONT_COLOR = "#32CD32";

    @Autowired
    protected WxMpConfigStorage configStorage;

    @Autowired
    protected WxMpService wxMpService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SqlUtils sqlUtils;

    @Modifying
    @Transactional
    public boolean checkUser(String account) {
        //  MD5Util.md5Encode()
        String s1 = String.format("SELECT * FROM sys_user WHERE account='%s'", account);
        try {
            List<Map<String, Object>> list = entityManager.createNativeQuery(s1).unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            if (list.size() > 0){
                return true; //存在用户
            } else {
                return false; //不存在用户
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    @Modifying
    @Transactional
    public String encryption(String password){
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            sha.update(password.getBytes("UTF-8"));
            System.out.println(sha.toString());
            byte[] _password = sha.digest();
            password = new BigInteger(1, _password).toString(16);
            return password;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "密码加密失败！";
        } catch (java.io.UnsupportedEncodingException e){
            e.printStackTrace();
            return "密码编码失败！";
        }
    }

    @Modifying
    @Transactional
    public String StatusNumToString(String num){
        try{
            String status = null;
            switch (num){
                case "0":
                    status = null;
                    break;
                case "1":
                    status = "同意";
                    break;
                case "2":
                    status = "拒绝";
                    break;
                case "3":
                    status = "驳回";
                    break;
                case "4":
                    status = "转交";
            }
            return status;
        } catch (Exception e){
         return "用户审批状态解析错误";
        }
    }

    @Modifying
    @Transactional
    public List<Map<String, Object>> ObjToList(Object obj, Class<Map> cla){
        List<Map<String, Object>> list = new ArrayList<>();
        if (obj instanceof ArrayList<?>){
            for (Object o : (List<?>) obj){
                list.add(cla.cast(o));
            }
            return list;
        }
        return null;
    }

    public String toDateSecond(long timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()));
    }

    public String toDateMillisecond(long timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");
        return dateTimeFormatter.format(Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()));
    }
}

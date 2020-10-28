package com.yearcon.projectsystem.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import java.io.IOException;
import okhttp3.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OkiHttp3工具类
 *
 * @return
 * @author kemengkai
 * @create 2020年10月21日
 */
@Service
@Slf4j
public class OkHttp3tUtil {
    // 初始值
    static final int timeOut = 10 * 1000;
    private HttpUrl url = null;
    OkHttpClient client = new OkHttpClient();
    MediaType ContentType = null;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");

    @Modifying
    @Transactional
    public String Get(String url) {
        this.url = HttpUrl.parse(url);
        Request request = null;
        if (this.url != null) {
            request = new Request.Builder()
                    .url(this.url)
                    .build();
        }
        if (request != null) {
            try (Response response = client.newCall(request).execute()) {
                return response.body() != null ? response.body().string() : null;
            } catch (IOException e) {
                e.printStackTrace();
                return "I/O错误";
            }
        }
        return "链接请求错误!";
    }

    @Modifying
    @Transactional
    public String Post(String url, String ContentType, String data) {
        this.url = HttpUrl.parse(url);
        if (ContentType.equals("json")){
            this.ContentType = JSON;
        } else {
            this.ContentType = XML;
        }
        RequestBody body = RequestBody.create(this.ContentType, data);
        Request request = new Request.Builder()
                .url(this.url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body() != null ? response.body().string() : null;
        } catch (IOException e) {
            e.printStackTrace();
            return "I/O错误!";
        }
    }
}
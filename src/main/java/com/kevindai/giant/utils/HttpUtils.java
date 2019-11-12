package com.kevindai.giant.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * @Author daiwenkai
 * @Date 11/11/2019 23:27
 **/
public class HttpUtils {
    public static String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(HttpEntity entity) {
        InputStream input = null;
        try {
            input = entity.getContent();
            return IOUtils.toString(input, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public static String toString(HttpEntity entity, Charset charset) {
        InputStream input = null;
        try {
            input = entity.getContent();
            return IOUtils.toString(input, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public static void close(HttpResponse response) {
        try {
            IOUtils.closeQuietly(response.getEntity().getContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toBase64(HttpEntity entity) {
        InputStream input = null;
        try {
            input = entity.getContent();
            return Base64.getEncoder().encodeToString(IOUtils.toByteArray(input));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    public static UrlEncodedFormEntity toUrlEncodedFormEntity(List<NameValuePair> params) {
        try {
            return new UrlEncodedFormEntity(params, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String unzipToString(HttpEntity entity, String charset) {
        GzipDecompressingEntity decompressingEntity = new GzipDecompressingEntity(entity);
        String content = "";
        try {
            content = EntityUtils.toString(decompressingEntity, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static ByteArrayOutputStream genByteArrayOs(String param) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayOutputStream originalContent = new ByteArrayOutputStream();
        GZIPOutputStream gzipOut = null;
        try {
            originalContent.write(param.getBytes());
            gzipOut = new GZIPOutputStream(baos);
            originalContent.writeTo(gzipOut);
            gzipOut.finish();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (gzipOut != null) {
                try {
                    gzipOut.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (originalContent != null) {
                try {
                    originalContent.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return baos;
    }
}

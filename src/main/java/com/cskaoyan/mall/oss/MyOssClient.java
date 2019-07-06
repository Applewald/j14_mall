package com.cskaoyan.mall.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mall.bean.CreateStorge;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@ConfigurationProperties(prefix = "myoss")
@Component
public class MyOssClient {
	private String bucket;
	private String endpoint ;
	private String accessKey ;
	private String secret ;

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public CreateStorge ossFileUpload(MultipartFile file) throws IOException {

		//文件上传
		InputStream inputStream = file.getInputStream();
		long size = file.getSize();
		String contentType = file.getContentType();

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength(size);
		objectMetadata.setContentType(contentType);

		PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, uuid, inputStream, objectMetadata);

		OSSClient ossClient = new OSSClient(endpoint, accessKey, secret);
		ossClient.putObject(putObjectRequest);


		//封装
		CreateStorge createStorge = new CreateStorge();

		createStorge.setType(contentType);
		createStorge.setName(file.getName());
		createStorge.setSize(size);
		createStorge.setKey(uuid);
		createStorge.setUrl("https://" + bucket +"." +endpoint +"/" + uuid);

		return createStorge;

	}


}

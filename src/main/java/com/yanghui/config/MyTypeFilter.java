package com.yanghui.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader:璇诲彇鍒扮殑褰撳墠姝ｅ湪鎵弿鐨勭被鐨勪俊鎭�
	 * metadataReaderFactory锛氬彲浠ヨ幏鍙栧埌鍏朵粬浠讳綍绫荤殑淇℃伅
	 */
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		//鑾峰彇褰撳墠绫绘敞瑙ｇ殑淇℃伅
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//鑾峰彇褰撳墠姝ｅ湪鎵弿鐨勭被鐨勭被淇℃伅
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//鑾峰彇褰撳墠绫昏祫婧愶紙绫荤殑璺緞锛�
		Resource resource = metadataReader.getResource();
		String className = classMetadata.getClassName();
		System.out.println("-->"+className);
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}

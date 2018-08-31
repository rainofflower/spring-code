package com.yanghui.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.yanghui.bean.Blue;
import com.yanghui.bean.Yellow;

//鑷畾涔夐�昏緫杩斿洖闇�瑕佸鍏ョ殑缁勪欢
public class MyImportSelector implements ImportSelector{

	//杩斿洖鍊硷紝灏辨槸瀵煎叆鍒板鍣ㄤ腑鐨勭粍浠跺叏绫诲悕
	//AnnotationMetadata锛氬綋鍓嶆爣娉ˊImport娉ㄨВ鐨勭被鐨勬墍鏈夋敞瑙ｄ俊鎭�
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		String blueClass = Blue.class.getName();
		String yellowClass = Yellow.class.getName();
		//importingClassMetadata.
		//鏂规硶杩斿洖null涔嬪悗澶勭悊杩囩▼涓細鎶涘嚭寮傚父锛屽洜姝や负绌哄簲璇ヨ繑鍥炵┖鏁扮粍
		return new String[]{blueClass,yellowClass};
	}

}

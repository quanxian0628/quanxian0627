package cn.kgc.tangcco.zhangqing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
	private int mId;
	private String mName;
	private String mURL;
}

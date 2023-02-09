package org.goonagoobob.domain.member;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class memberChangeInfo {
	public String mid;
	public String memail;
	public String mname;
	public String mbirth;
}

package jsp_ex25_2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {

	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response);

}

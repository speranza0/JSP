package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Dto;

public class SelectOneCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strID = request.getParameter("idx");
		Dao dao = new Dao();
		Dto dto = dao.selectOne(strID);
		
		request.setAttribute("selectOne", dto);
	}
}

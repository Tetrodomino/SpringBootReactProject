package com.example.reactProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactProject.dao.UserDao;
import com.example.reactProject.entity.User;

@SuppressWarnings("unchecked")
@RestController // rendering 하지 않고 데이터를 보내는 컨트롤러 (ResponseBody)
@RequestMapping("/react")
public class ReactController {
	@Autowired private UserDao uDao;

	@GetMapping("/data")
	public String data() {
		return "스프링부트에서 보낸 데이터";
	}
	
	@GetMapping("/json")
	public String json() {
		JSONObject jObj = new JSONObject();
		jObj.put("uid", "james");
		jObj.put("uname", "제임스");
		
		return jObj.toString();
	}
	
	@PostMapping("/form")
	public String form (String uid, String uname) {
		System.out.println("uid: " + uid + ", uname: " + uname);
		return "uid: " + uid + ", uname: " + uname;
	}
	
	@GetMapping("/users")
	public JSONArray users () {
		List<User> lists = new ArrayList<>();
		lists = uDao.getUserList(10, 0);
		JSONArray jArr = new JSONArray();
		try {
			for (User user : lists) {
				JSONObject jb = new JSONObject();
				jb.put("uid", user.getUid());
				jb.put("uname", user.getUname());
				jb.put("email", user.getEmail());
				jb.put("regDate", user.getRegDate());
				jb.put("profile", user.getProfile());
				jb.put("github", user.getGithub());
				jb.put("insta", user.getInsta());
				jb.put("location", user.getLocation());
				jArr.add(jb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(lists);
		
		return jArr;
	}
}

package com.fundoo.controllers;








import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo.dto.UserDto;
import com.fundoo.models.LogInTime;
import com.fundoo.models.Response;
import com.fundoo.models.User;
import com.fundoo.services.UserService;
import com.fundoo.utility.UserToken;




@RestController
@CrossOrigin(origins = {})
public class UserController {
	
	
	
	@Autowired
      UserService userService;
	
    
	
	@RequestMapping("/")
	public String welcome()
	{
		return "welcome";
	}

	@RequestMapping(value="/create",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody User user)
	{
	
		userService.create(user);
		System.out.println(user);

		System.out.println("saved successfully");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	
}


	@RequestMapping(value="/read",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> read(@RequestBody User user )
	{
		//System.out.println("Read : "+user.getUserName()+" "+user.getPassword());
		String status = userService.read(user);
		System.out.println("Status is :"+status);
		Response response = new Response();
		response.setStatus(status);
		
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
		
		
		
		
	
	
	@RequestMapping(value="/forgetpassword",method=RequestMethod.POST)
	public ResponseEntity<?> getPassword(@RequestParam String emailId,User user)
	{
		System.out.println("email id : "+emailId);
		
		userService.forgetPassword(emailId,user );
		return new ResponseEntity<String>(emailId,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> RegisterUser(@RequestBody User user)
	{
	  
	    String emailId = null;
		userService.RegisterUser(emailId);
		

		System.out.println("register succesfully");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	
}
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
	
		userService.saveUser(user);
		System.out.println(user);

		System.out.println("registeruser  successfully");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	
}
	



	@RequestMapping(value="/login",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> login(@RequestBody UserDto user, HttpServletResponse httpServletResponse) throws Exception{

	   Response	response = new Response();

		User check = userService.verifyUser(user);

		System.out.println("usercon  " + check);

		if (check != null) {
			if (check.getRole().equals("admin")) {
				String token = UserToken.generateToken(check.getId());
				check.setLastloginStamp(new Date());				
				userService.updapteUser(check);
				
				
//				httpServletResponse.addHeader("jwtTokenxxx", token);
//				System.out.println(token);
				response.setToken(token);
				response.setMessage("admin");
				return new ResponseEntity<Response>(response, HttpStatus.OK);

			} else if (check.getRole().equals("user")) {
				response.setMessage("user");
				return new ResponseEntity<Response>(response, HttpStatus.OK);

			}

		}

		  response.setMessage("invalid");
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
	
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestHeader("token") String token) {

		User user = userService.getUser(token);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	
	
	@RequestMapping(value="/logInTime",method= RequestMethod.GET)
	public ResponseEntity <List<LogInTime>> getTime(@RequestHeader("token") String token){
		
		
		List<LogInTime> logTime=userService.getTime(token);
		
		
		return new ResponseEntity<List<LogInTime>>(logTime,HttpStatus.OK);
		
		
	}
	
	
	
	
	
	

	}


//		
//	}
//	
//	

//
//	
//	
//	
//	
//	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
//	public ResponseEntity<Response> registerUser(@RequestBody User tempUser )
//	{
//	
//		System.out.println(tempUser);
//		boolean check=userService.addUser(tempUser);
//		
//		response=new Response();
//		if(check)
//		{
//			response.setStatusCode(200);
//			response.setStatus("register successfull");
//			return new ResponseEntity<Response>(response,HttpStatus.OK);
//		}
//		response.setStatus("register unsuccessfull");
//		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
//	}
//	
//	
//	
//	@RequestMapping("/updateUser/{id}")
//	public ResponseEntity<Response> updateUser(@RequestBody User user,@PathVariable Integer id)
//	{
//		boolean check=userService.updateUser(user,id);
//		response=new Response();
//		if(check)
//		{
//			response.setStatus("updated successfully");
//			return new ResponseEntity<Response>(response,HttpStatus.OK);
//		}
//		response.setStatus("id is not valid");
//		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
//		
//	}
//	
//	
//	@RequestMapping("/deleteUser/{id}")
//	public ResponseEntity<Response> deleteUser(@PathVariable Integer id)
//	{
//		boolean check=userService.deleteUser(id);
//		response=new Response();
//		if(check)
//		{
//			response.setStatus("delete successfully");
//			return new ResponseEntity<Response>(response,HttpStatus.OK);
//		}
//		response.setStatus("user is not found");
//		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
//	}
//	
//	
//	
//	@RequestMapping(value="/forgetPassword", method=RequestMethod.POST)
//	public ResponseEntity<Response > forgetPassword(@RequestBody User user)
//	{
//		forgetUser=new User();
//		forgetUser=user;
//		boolean check=userService.forgetPassword(user);
//		response=new Response();
//		if(check)
//		{
//			response.setStatusCode(200);
//			response.setStatus("otp send successfully");
//			return new ResponseEntity<Response>(response,HttpStatus.OK);
//		}
//		response.setStatusCode(404);
//		response.setStatus("email id is not valid");
//		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
//				
//	}
//	
//
//	@RequestMapping(value="/forgetOtpVerification", method=RequestMethod.POST)
//	public ResponseEntity<Response> forgetOtpVerify(@RequestBody GenerateOtp generateOtp)
//	{
//		boolean check=userService.forgetVerification(generateOtp,forgetUser);
//		response=new Response();
//		if(check)
//		{
//			response.setStatusCode(200);
//			response.setStatus("reset successfully");
//		return new ResponseEntity<Response>(response,HttpStatus.OK);
//		}
//		response.setStatusCode(404);
//		response.setStatus("otp is wrong");
//		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
//	}
//	
//	
//	
//	
//	
//	
//}	
//	
//
//			

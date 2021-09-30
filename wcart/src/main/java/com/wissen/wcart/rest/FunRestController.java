/*
 * package com.wissen.wcart.rest;
 * 
 * import java.time.LocalDateTime;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class FunRestController {
 * 
 * // inject custom properties for coach.name and team.name
 * 
 * @Value("${coach.name}") private String coachName;
 * 
 * @Value("${team.name}") private String teamName;
 * 
 * // expose a new method for team info
 * 
 * @GetMapping("/teamInfo") public String getTeamInfo() { return
 * "Coach Name : "+ coachName+" , Team Name : "+teamName; }
 * 
 * 
 * @GetMapping("/") public String sayHello() { return
 * "Hello World!! Time on server is :- " + LocalDateTime.now(); }
 * 
 * }
 */
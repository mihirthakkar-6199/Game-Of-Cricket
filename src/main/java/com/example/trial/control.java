package com.example.trial;

import org.springframework.web.bind.annotation.*;

@RestController
public class control {
    @RequestMapping("/")
    public String index(){
        String fin="<html>\n" +
                "<body>\n" +
                "\n" +
                "<center>\n"+
                "<h2>WELCOME</h2>\n" +
                "\n" +
                "<form action=\"/new\">\n" +
                "  Team Name 1:\n" +
                "  <input type=\"text\" name=\"team1\">\n" +
                "  <br><br>\n" +
                "   Team Name 2:\n" +
                "  <input type=\"text\" name=\"team2\">\n" +
                "  <br><br>\n" +
                "   Number of overs:\n" +
                "  <input type=\"text\" name=\"over\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "</center>\n"+
                "</body>\n" +
                "</html>";
        return fin;
    }
    @GetMapping("/new")
    @ResponseBody
    public String index1(@RequestParam(name="team1") String team1,@RequestParam(name="team2") String team2,@RequestParam(name="over") String over)
    {
        match m = new match(team1,team2,Integer.parseInt(over));
        String r = m.startmatch();
        System.out.println(r);
        return r;
    }
}

package com.example.trial;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

public class innings {
    private int runs=0,wickets=0,balls=0,strikeRate1=0,strikeRate2=1,currBowler=6;
    private ArrayList<over> data = new ArrayList<>();
    public Pair<String,Integer> startInnings(team bat,team bowl,int number,int target,int overs,String s){
        s+="<h2>Innings "+number+"</h2>";
        int flag=0;
        System.out.println("Start");
        for(int i=1;i<=overs;i++)
        {
            over newOver = new over();
            int temp=0;
            if(currBowler==11)
                currBowler=6;
            for(int j=1;j<=6;j++)
            {
                if(number==2 && runs>target)
                {
                    flag=1;
                    break;
                }
                if(wickets==10){
                    flag=1;
                    break;
                }
                Random rand = new Random();
                int next = rand.nextInt(8);
                balls++;
                newOver.setBallInfo(next);
                if(next>=0 && next<=6)
                    temp+=next;
                System.out.println(strikeRate1+" "+strikeRate2);
                bowl.setBowlerNoOfBallsBowled(currBowler,bowl.getBowlerNoOfBallsBowled(currBowler)+1);
                bat.setBatsmenNoOfBallsPlayed(strikeRate1,bat.getBatsmenNoOfBallsPlayed(strikeRate1)+1);
                if(next==7)
                {
                    wickets++;
                    bat.setwicket(bat.getwicket()+1);
                    bowl.setBowlerWicketsTaken(currBowler,bowl.getBowlerWicketsTaken(currBowler)+1);
                    if(strikeRate1>strikeRate2)
                        strikeRate1++;
                    else if(strikeRate1<strikeRate2)
                        strikeRate1=strikeRate2+1;
                }
                else
                {
                    bat.setBatsmenNoOfRuns(strikeRate1,bat.getBatsmenNoOfRuns(strikeRate1)+next);
                    bowl.setBowlerRunsGiven(currBowler,bowl.getBowlerRunsGiven(currBowler)+next);
                    bat.setrun(bat.getrun()+next);
                    bat.setball(bat.getball()+1);
                    runs+=next;
                    if(next==4)
                        bat.setBatsmenNoOfFours(strikeRate1,bat.getBatsmenNoOfFours(strikeRate1)+1);
                    if(next==6)
                        bat.setBatsmenNoOfSixes(strikeRate1,bat.getBatsmenNoOfSixes(strikeRate1)+1);
                    if(next%2==1)
                    {
                        int temp1=strikeRate2;
                        strikeRate2=strikeRate1;
                        strikeRate1=temp1;
                    }
                }
            }
            data.add(newOver);
            if(temp==0)
                bowl.setBowlerMaidenOvers(currBowler,bowl.getBowlerMaidenOvers(currBowler)+1);
            currBowler++;
            if(flag==1) {
                break;
            }
        }
        target=runs;
        return new Pair<String,Integer>(s,target);
    }
    public String scoreboard(team bat,team bowl,String s)
    {
        s+="<h3>"+bat.getname()+" Batting Scorecard</h3>";
        s+="<b>Total:"+runs+"/"+wickets+"("+find(balls)+")</b><br><br>";
        s+="<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 50%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Player Name</th>\n" +
                "    <th>Runs Scored</th>\n" +
                "    <th>Balls Faced</th>\n" +
                "    <th>Fours Scored</th>\n"+
                "<th>Sixes Scored</th>\n"+
                "  </tr>\n";

        for(int i=0;i<11;i++)
        {
            s+="  <tr>\n" +
                    "    <td>"+bat.getBatsmenName(i)+"</td>\n" +
                    "    <td>"+bat.getBatsmenNoOfRuns(i)+"</td>\n" +
                    "    <td>"+bat.getBatsmenNoOfBallsPlayed(i)+"</td>\n" +
                    "<td>"+bat.getBatsmenNoOfFours(i)+"</td>\n"+
                    "<td>"+bat.getBatsmenNoOfSixes(i)+"</td>\n"+
                    "  </tr>";
        }
        s+="</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        s+="<h3>"+bowl.getname()+" Bowling Scorecard</h3>";
        s+="<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 50%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Player Name</th>\n" +
                "    <th>Overs Bowled</th>\n" +
                "    <th>Runs Given</th>\n" +
                "    <th>Wickets Taken</th>\n"+
                "   <th>Maiden Overs</th>\n"+
                "  </tr>\n";

        for(int i=6;i<11;i++)
        {
            s+="  <tr>\n" +
                    "    <td>"+bowl.getBowlerName(i)+"</td>\n" +
                    "    <td>"+find(bowl.getBowlerNoOfBallsBowled(i))+"</td>\n" +
                    "    <td>"+bowl.getBowlerRunsGiven(i)+"</td>\n" +
                    "<td>"+bowl.getBowlerWicketsTaken(i)+"</td>\n"+
                    "<td>"+bowl.getBowlerMaidenOvers(i)+"</td>\n"+
                    "  </tr>";
        }
        s+="</table>\n" +
                "\n" +
                "</body>\n" +
                "</html><br>";
        return s;
    }
    public float find(int ball){
        if(ball%6==0) return ball/6;
        else if(ball%6==1) return (float) (ball/6+0.1);
        else if(ball%6==2) return (float) (ball/6+0.2);
        else if(ball%6==3) return (float) (ball/6+0.3);
        else if(ball%6==4) return (float) (ball/6+0.4);
        else return (float) (ball/6+0.5);
    }
}

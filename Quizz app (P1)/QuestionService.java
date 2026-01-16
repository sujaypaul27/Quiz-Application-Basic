import java.util.Scanner;

public class QuestionService{
    Question[] questions =new Question[5];// this is only reference of question array not object
    String[] useranswers=new String[5];

    public QuestionService(){
        questions[0]=new Question(1,"Which starts with Go","a) joe","b) Kiran","c) Gopi","d) tamil","c");
        questions[1]=new Question(1,"Which starts with j","a) joe","b) Kiran","c) Gopi","d) tamil","a");
        questions[2]=new Question(1,"Which starts with K","a) joe","b) Kiran","c) Gopi","d) tamil","b");
        questions[3]=new Question(1,"Which starts with G","a) joe","b) Kiran","c) Gopi","d) tamil","c");
        questions[4]=new Question(1,"Which starts with t","a) joe","b) Kiran","c) Gopi","d) tamil","d");

    }
    public void Startquizz(){
        Scanner sc =new Scanner(System.in);
        int i=0;
           System.out.println();
        System.out.println();
        System.out.println(" FOR ANSWERS TYPE ONLY THE FOLLOWING OPTION (eg:=  a or b or c or d )");
        System.out.println();
        System.out.println();
        for(Question q: questions){
        System.out.println(q.getQuestion()+" ?  "+q.getOpt1()+"  "+q.getOpt2()+"  "+q.getOpt3()+" "+q.getOpt4());//since for each loop we need to print based on index
        
        
        useranswers[i]=sc.nextLine();
        i++;//for manual increment for input answer
        }
        int j=1;// for understanding answers with qstn number
        for(String a : useranswers){
            
            System.out.println(j+")  "+"Confirmed Answer "+a);
            j++;
        }
    }
    public void resultdisplay(){
        int score =0;
        System.out.println();
         System.out.println();
          System.out.println(" Your score out of "+questions.length+" questions . Each carries 10 Marks.");
           System.out.println(); System.out.println();
        for(int i=0;i<questions.length;i++){
            Question q1 =questions[i];
            String answer=q1.getAnswer();
            String getuseranswer=useranswers[i];
            if(answer.equalsIgnoreCase(getuseranswer)){
                score+=10;
            }

    }
     System.out.println("Result := "+ score);
}
}
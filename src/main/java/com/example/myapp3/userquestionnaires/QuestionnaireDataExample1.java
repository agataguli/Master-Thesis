package com.example.myapp3.userquestionnaires;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionnaireDataExample1 extends QuestionnaireData {

    //questions from: https://dariusforoux.com/21-questions/

    private String amIHappy; //1

    private String amIGrateful; //2

    private String doILikeMyJob; //3

    private String doIFeelGood; //4

    private String doISpendEnoughTimeOnMyEducation; //5

    private String whatNewThingsAmILearning; //6

    private String whereIsMyCareerGoing; //7

    private String howMeaningfulIsMyWork; //8

    private String whatCanIDoThatIMCurrentlyNotDoing; //9

    private String howCanIGetBetterAtWhatIDo; //10

    private String whatIsTheBiggestPainPointThatOurClientsCustomersHave; //11

    private String whatIsTheIdealSolutionInTheEyesOfOurClientsCustomers; //12

    private String howCanWeGiveAwayMoreValueWithoutChargingMore; //13

    private String howCanWeDecreaseOurCosts; //14

    private String whatTasksShouldIStopDoing; //15

    private String whatTasksAmIProcrastinating; //16

    private String whatQuestionsAmINotAskingMyself; //17

    private String howCanIHelpOnePersonToday; //18

}

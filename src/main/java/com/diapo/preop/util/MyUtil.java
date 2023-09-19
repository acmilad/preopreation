package com.diapo.preop.util;

import com.diapo.preop.model.Answer;
import com.diapo.preop.model.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.List;

public class MyUtil {
    public static String objectToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String answerToJson(Answer answer) throws JsonProcessingException {
        JSONObject jsonObject;
        ObjectMapper mapper = new ObjectMapper();
        jsonObject = new JSONObject(mapper.writeValueAsString(answer));
        if (answer.getPatient() != null) {
            JSONObject patientJson = new JSONObject(mapper.writeValueAsString(answer.getPatient()));
            jsonObject.put("patient", patientJson);
        }
        if (answer.getQuestion() != null) {
            JSONObject questionJson = new JSONObject(mapper.writeValueAsString(answer.getQuestion()));
            jsonObject.put("question", questionJson);
        }
        return jsonObject.toString();
    }


    public static String patientToJson(Patient patient) throws JsonProcessingException {
        JSONObject jsonObject;
        ObjectMapper mapper = new ObjectMapper();
        jsonObject = new JSONObject(mapper.writeValueAsString(patient));
        return jsonObject.toString();
    }

    public static String patientAnswerToJson(List<Answer> answers) throws JsonProcessingException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        ObjectMapper mapper = new ObjectMapper();
        for (Answer answer : answers) {
            jsonObject = new JSONObject(mapper.writeValueAsString(answer));
            if (answer.getQuestion() != null){
                jsonObject.put("question_id", answer.getQuestion().getId());
            }
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }
}

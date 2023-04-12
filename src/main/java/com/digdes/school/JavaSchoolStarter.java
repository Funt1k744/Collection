package com.digdes.school;

import java.util.*;

public class JavaSchoolStarter {

    private List<Map<String,Object>> table = new ArrayList<>();

    public JavaSchoolStarter(){

    }

    public List<Map<String, Object>> getTable() {
        return table;
    }

    public void setTable(List<Map<String, Object>> table) {
        this.table = table;
    }

    public List<Map<String,Object>> execute(String request) throws Exception {
        String[] queryParts = request.split(" ");
        String operation = queryParts[0].toLowerCase();

        Map<String, Object> column = new HashMap<>();

        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<String> columnsCondition = new ArrayList<>();
        List<String> valuesCondition = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        String[] dataParts = null;
        String[] conditionParts = null;

        if (operation.equals("insert")) {
            dataParts = request.substring(14).split(",");

            for (String dataPart : dataParts) {
                String[] keyValue = dataPart.trim().split("=");
                columns.add(keyValue[0].replaceAll("'", "").trim());
                values.add(keyValue[1].replaceAll("'", "").trim());
            }

            if (idNumber(columns) == null) {
                column.put("id", null);
            } else {
                column.put("id", Long.parseLong(values.get(idNumber(columns))));
            }

            if (lastNameNumber(columns) == null) {
                column.put("lastName", null);
            } else {
                column.put("lastName", values.get(lastNameNumber(columns)));
            }

            if (costNumber(columns) == null) {
                column.put("cost", null);
            } else {
                column.put("cost", Double.parseDouble(values.get(costNumber(columns))));
            }

            if (ageNumber(columns) == null) {
                column.put("age", null);
            } else {
                column.put("age", Long.parseLong(values.get(idNumber(columns))));
            }

            if (activeNumber(columns) == null) {
                column.put("active", null);
            } else {
                column.put("active", Boolean.parseBoolean(values.get(activeNumber(columns))));
            }

            table.add(column);
            return table;
        } else if (operation.equals("update")) {
            if (!request.matches("(?i).*where.*")) {
                dataParts = request.substring(14).split(",");

                for (String dataPart : dataParts) {
                    String[] keyValue = dataPart.trim().split("=");
                    columns.add(keyValue[0].replaceAll("'", "").trim());
                    values.add(keyValue[1].replaceAll("'", "").trim());
                }

                if (idNumber(columns) == null) {
                    column.put("id", null);
                } else {
                    column.put("id", Long.parseLong(values.get(idNumber(columns))));
                }

                if (lastNameNumber(columns) == null) {
                    column.put("lastName", null);
                } else {
                    column.put("lastName", values.get(lastNameNumber(columns)));
                }

                if (costNumber(columns) == null) {
                    column.put("cost", null);
                } else {
                    column.put("cost", Double.parseDouble(values.get(costNumber(columns))));
                }

                if (ageNumber(columns) == null) {
                    column.put("age", null);
                } else {
                    column.put("age", Long.parseLong(values.get(idNumber(columns))));
                }

                if (activeNumber(columns) == null) {
                    column.put("active", null);
                } else {
                    column.put("active", Boolean.parseBoolean(values.get(activeNumber(columns))));
                }

                for (Map<String, Object> stringObjectMap : table) {
                    if (!(column.get("id") == (null))) {
                        stringObjectMap.put("id", column.get("id"));
                    }
                    if (!(column.get("lastName") == (null))) {
                        stringObjectMap.put("lastName", column.get("lastName"));
                    }
                    if (!(column.get("cost") == (null))) {
                        stringObjectMap.put("cost", column.get("cost"));
                    }
                    if (!(column.get("age") == (null))) {
                        stringObjectMap.put("age", column.get("age"));
                    }
                    if (!(column.get("active") == (null))) {
                        stringObjectMap.put("active", column.get("active"));
                    }
                }

                return table;
            } else {
                dataParts = request.substring(14, firstLetterNumber(request, "where")).split(",");
                conditionParts = request.substring(firstLetterNumber(request, "where") + 6).split(",");

                for (String dataPart : dataParts) {
                    String[] keyValue = dataPart.trim().split("=");
                    columns.add(keyValue[0].replaceAll("'", ""));
                    values.add(keyValue[1].replaceAll("'", ""));
                }

                for (String conditionPart : conditionParts) {
                    if (conditionPart.contains("=")) {
                        String[] keyValue = conditionPart.trim().split("=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("=");
                    } else if (conditionPart.contains("!=")) {
                        String[] keyValue = conditionPart.trim().split("!=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("!=");
                    } else if (conditionPart.contains(">=")) {
                        String[] keyValue = conditionPart.trim().split(">=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add(">=");
                    } else if (conditionPart.contains("<=")) {
                        String[] keyValue = conditionPart.trim().split("<=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("<=");
                    } else if (conditionPart.contains("<")) {
                        String[] keyValue = conditionPart.trim().split("<");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("<");
                    } else if (conditionPart.contains(">")) {
                        String[] keyValue = conditionPart.trim().split(">");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add(">");
                    } else if (conditionPart.contains("like")) {
                        String[] keyValue = conditionPart.trim().split("like");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("like");
                    } else if (conditionPart.contains("ilike")) {
                        String[] keyValue = conditionPart.trim().split("ilike");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("ilike");
                    }
                }
            }
        } else if (operation.equals("delete")) {
            if (!request.matches("(?i).*where.*")) {
                    table.removeAll(table);
                return table;
            } else {
                conditionParts = request.substring(13).split(",");

                for (String conditionPart : conditionParts) {
                    if (conditionPart.contains("=")) {
                        String[] keyValue = conditionPart.trim().split("=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("=");
                    } else if (conditionPart.contains("!=")) {
                        String[] keyValue = conditionPart.trim().split("!=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("!=");
                    } else if (conditionPart.contains(">=")) {
                        String[] keyValue = conditionPart.trim().split(">=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add(">=");
                    } else if (conditionPart.contains("<=")) {
                        String[] keyValue = conditionPart.trim().split("<=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("<=");
                    } else if (conditionPart.contains("<")) {
                        String[] keyValue = conditionPart.trim().split("<");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("<");
                    } else if (conditionPart.contains(">")) {
                        String[] keyValue = conditionPart.trim().split(">");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add(">");
                    } else if (conditionPart.contains("like")) {
                        String[] keyValue = conditionPart.trim().split("like");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("like");
                    } else if (conditionPart.contains("ilike")) {
                        String[] keyValue = conditionPart.trim().split("ilike");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("ilike");
                    }
                }

            }
        } else if (operation.equals("select")) {
            if (!request.matches("(?i).*where.*")) {
                return table;
            } else {
                conditionParts = request.substring(13).split(",");

                for (String conditionPart : conditionParts) {
                    if (conditionPart.contains("=")) {
                        String[] keyValue = conditionPart.trim().split("=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("=");
                    } else if (conditionPart.contains("!=")) {
                        String[] keyValue = conditionPart.trim().split("!=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("!=");
                    } else if (conditionPart.contains(">=")) {
                        String[] keyValue = conditionPart.trim().split(">=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add(">=");
                    } else if (conditionPart.contains("<=")) {
                        String[] keyValue = conditionPart.trim().split("<=");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("<=");
                    } else if (conditionPart.contains("<")) {
                        String[] keyValue = conditionPart.trim().split("<");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("<");
                    } else if (conditionPart.contains(">")) {
                        String[] keyValue = conditionPart.trim().split(">");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add(">");
                    } else if (conditionPart.contains("like")) {
                        String[] keyValue = conditionPart.trim().split("like");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("like");
                    } else if (conditionPart.contains("ilike")) {
                        String[] keyValue = conditionPart.trim().split("ilike");
                        columnsCondition.add(keyValue[0].replaceAll("'", ""));
                        valuesCondition.add(keyValue[1].replaceAll("'", ""));
                        operators.add("ilike");
                    }
                }
            }


        }

        return table;
    }

    public Integer idNumber(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("(?i).*" + "id" + ".*")) {
                return i;
            }
        }
        return null;
    }

    public Integer lastNameNumber(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("(?i).*" + "lastName" + ".*")) {
                return i;
            }
        }
        return null;
    }

    public Integer costNumber(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("(?i).*" + "cost" + ".*")) {
                return i;
            }
        }
        return null;
    }

    public Integer ageNumber(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("(?i).*" + "age" + ".*")) {
                return i;
            }
        }
        return null;
    }

    public Integer activeNumber(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("(?i).*" + "active" + ".*")) {
                return i;
            }
        }
        return null;
    }

    public Integer firstLetterNumber(String text, String word) {
        return text.toLowerCase().indexOf(word.toLowerCase());
    }
}


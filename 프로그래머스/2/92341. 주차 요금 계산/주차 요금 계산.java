import java.util.*;
class Solution {
    static class ParkingLog {
        final int minute;
        final String log;
        
        ParkingLog(String time, String log) {
            String[] temp = time.split(":");
            int minute = Integer.parseInt(temp[0]) * 60;
            minute += Integer.parseInt(temp[1]);
  
            this.minute = minute;
            this.log = log;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, List<ParkingLog>> carNumber = new TreeMap<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" "); // 입출차 기록
            int carId = Integer.parseInt(record[1]); // 차량 번호
            
            if(carNumber.containsKey(carId)) { // 차가 이미 Map안에 있다.         
                List<ParkingLog> logs = carNumber.get(carId); // 입출차 기록
                ParkingLog lastLog = logs.get(logs.size() - 1); // 마지막 기록
                
                if(lastLog.log.equals("IN")) { // 마지막이 입차인가?
                    logs.add(new ParkingLog(record[0], record[2])); // 출차 기록
                }
                
                if(lastLog.log.equals("OUT")) { // 마지막이 출차인가?
                    logs.add(new ParkingLog(record[0], record[2])); // 입차 기록
                }
            } 
            
            if(!carNumber.containsKey(carId)) {
                List<ParkingLog> logs = new ArrayList<>(); // 로그 생성
                logs.add(new ParkingLog(record[0], record[2])); // 로그 추가
                carNumber.put(carId, logs); // Map에 첫 기록
            }
        }
        
        int[] result = new int[carNumber.size()]; // 결과 기록하는 곳
        int i = 0; // 기록 순서
        
        for(List<ParkingLog> logs : carNumber.values()) {
            ParkingLog lastLog = logs.get(logs.size() - 1);
            int allTime = 0;
            int in = 0;
            
            for(ParkingLog log : logs) { // 전체 시간 기록
                if ("IN".equals(log.log)) { // in이면 시간 기록
                    in = log.minute;
                } else { // out이면 시간 계산 후 기록
                    allTime += log.minute - in;
                }
            }
            
            if("IN".equals(lastLog.log)) {
                allTime += (23 * 60 + 59) - in;
            }
            
            if(allTime <= fees[0]) {
                result[i++] = fees[1];
                continue;
            }
            
            if((allTime - fees[0]) % fees[2] != 0) {
                result[i++] = fees[1] + ((((allTime - fees[0]) / fees[2]) + 1) * fees[3]);
            } else {
                result[i++] = fees[1] + (((allTime - fees[0]) / fees[2]) * fees[3]);
            }
        }
        return result;
    }
}
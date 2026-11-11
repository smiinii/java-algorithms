class Solution {
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        int[] new_x = {0, 0, 1, -1}; // 동 서 남 북
        int[] new_y = {1, -1, 0, 0}; // 동 서 남 북
        
        for(int x = 0; x < places.length; x++) { // 행
            String[][] map = new String[5][places[0][0].length()]; // 한 행별로 만들 대기실 2차원 배열 지도
            result[x] = 1;
            
            for(int y = 0; y < 5; y++) { // 열
                for(int i = 0; i < places[0][0].length(); i++) { // 2차원 배열 초기화
                    map[y][i] = String.valueOf(places[x][y].charAt(i));
                }
            }
            
            q : for(int z = 0; z < map.length; z++) { // 2차원 배열 행 
                for(int n = 0; n < map[0].length; n++) { // 2차원 배열 열
                    if(map[z][n].equals("P")) { // 사람이면
                        for(int k = 0; k < 4; k++) {
                            int temp_x = z + new_x[k]; // 한칸 올라온거
                            int temp_y = n + new_y[k];
                            
                            if(temp_x < 0 || temp_x >= map.length || temp_y < 0 || temp_y >= map[0].length) { // 인덱스 넘어가지 않게
                                continue;
                            }
                            
                            if(map[temp_x][temp_y].equals("P")) { // 인접한 곳에 사람이 있다.
                                result[x] = 0;
                                break q;
                            }
                            
                            if(map[temp_x][temp_y].equals("O")) { // 빈 책상이다.
                                for(int m = 0; m < 4; m++) { 
                                    int m_temp_x = temp_x + new_x[m]; // 한칸 올라온거 기준으로 동서남북
                                    int m_temp_y = temp_y + new_y[m];
                                    
                                    if(m_temp_x < 0 || m_temp_x >= map.length || m_temp_y < 0 || m_temp_y >= map[0].length) { 
                                        continue; // 맵 넘어가는지
                                    }
                                    
                                    if(z == m_temp_x && n == m_temp_y) {
                                        continue; // 원위치
                                    }
                                    
                                    if(map[m_temp_x][m_temp_y].equals("P")) { // 맨해튼 거리에 사람이 있나?
                                        result[x] = 0;
                                        break q;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }    
        return result;
    }
}
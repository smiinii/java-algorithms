class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = a + 1; b <= n; b++) {
                for (int c = b + 1; c <= n; c++) {
                    for (int d = c + 1; d <= n; d++) {
                        for (int e = d + 1; e <= n; e++) {
                            int[] code = {a, b, c, d, e};
                            boolean valid = true;

                            // 후보 하나를 모든 시도와 비교
                            for (int i = 0; i < q.length; i++) {
                                int matched = 0;

                                for (int j = 0; j < 5; j++) {
                                    for (int k = 0; k < 5; k++) {
                                        if (q[i][j] == code[k]) {
                                            matched++;
                                            break;
                                        }
                                    }
                                }

                                // 한 줄이라도 맞힌 개수가 다르면 이 후보는 탈락
                                if (matched != ans[i]) {
                                    valid = false;
                                    break;
                                }
                            }

                            if (valid) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
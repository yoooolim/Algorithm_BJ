# Algorithm_BJ


입출력 - 2557, 1000, 2558, 10950, 10951, 10952, 10953, 11021, 11022, 11718, 11719, 11720, 11721, 2741​​, 2742, 2739, 1924, 8393, 10818, 2438, 2439, 2440, 2441, 2442, 2445, 2522, 2446, 10991, 10992

Baekjoon.DP - 1463, 11726, 11727, 9095, 10844, 11057, 2193, 9465, 2156, 11053, 11055, 11722, 11054, 1912, 2579, 1699, 2133, 9461, 2225, 2011, 11052

이런저런 - 2751, 11650, 11651, 10814, 10825, 10989, 11652, 11004, 10828, 9012, 10799, 10845, 10866, 10808, 10809, 10820, 2743, 11655, 10824, 11656, 1406, 1158, 1168, 10430, 2609, 1934, 1850, 9613, 11005, 2745, 1373, 1212, 2089, 11576, 1978, 1929, 6588, 11653, 10872, 1676, 2004

그래프 - 1260, 11724, 1707, 10451, 2331, 9466, 2667, 4963, 7576, 2178, 2146, 1991, 11725, 1167, 1967

이분탐색/삼분탐색 - 1654, 2805, 2110, 10815, 10816, 11662


분할정복 - 11728, 1780, 11729, 1992, 2447, 2448, 1517, 2261

그리디 - 11047, 2875, 10610, 1783, 1931, 11399, 2873, 1744

완전탐색 - 1476, 1107, 1451, 9095, 10819, 10971, 1697, 1963, 9019, 1525, 2251, 2186, 3108, 5014, 1759, 2580, 1987, 6603, 1182, 2003, 1806, 1644, 1261, 1208, 7453, 2632, 2143

-----------------------------------------------------------

#### 10844


수의 일의 자리 숫자가 될 수 있는 것 = (0 ~ 9)
일의 자리 숫자가 0이 되려면 십의 자리 숫자가 1이여야 함.
일의 자리 숫자가 1이 되려면 십의 자리 숫자가 0,2여야 함.

==> n자리 계단수 중 일의 자리 숫자가 i인 수의 개수는, n-1자리 계단 수 중 일의 자리 숫자가 i-1, i+1인 수의 개수를 더한 것과 같다.
==> Baekjoon.DP[n][i]=Baekjoon.DP[n-1][i-1] + Baekjoon.DP[n-1][i+1]

ex ) 
STEP1 . 3자리 계단 수 중 일의 자리 숫자가 2인 수는, 십의 자리 숫자가 1이거나 3이여야 한다.
STEP2 . 결국 2자리 계단 수 중 일의 자리 숫자가 1인 것의 맨 마지막에 2를 추가한 것과 일의 자리 숫자가 3인 것의 맨 마지막에 2을 추가한 것이 일의 자리가 2가 되는 모든 경우이다.
STEP3 . 계산 해 놓은 2자리 계단 수 중 일의 자리 숫자가 1인 것의 개수와 3인 것의 개수를 더하면 3자리 계단 수 중 일의 자리 숫자가 2인 수가 된다.
![10844](https://user-images.githubusercontent.com/37526372/106466278-7a29a900-64de-11eb-91f8-547b4fadb998.png)

-----------------------------------------------------------------

### BOJ




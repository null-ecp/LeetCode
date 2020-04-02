class Solution {
    public static String multiply(String num1, String num2) {
        if("".equals(num1)||"".equals(num2)) return "";
        if("0".equals(num1)||"0".equals(num2)) return "0";

        StringBuffer sb = new StringBuffer();

        int len1 = num1.length();
        int len2 = num2.length();

        int reslen = len1 + len2;
        // 两数相乘最大值的长度不会超过两数长度之和
        int[] resarr = new int[reslen];

        for (int i = len1 - 1; i >= 0; i--){
            // 获取乘数1 的 最后一位数
            int temp1 = num1.charAt(i) - '0';
            // 乘数2 的每个数字循环相乘
            // 将获得的值先放入数组中
            for (int j = len2 - 1; j >= 0; j--){
                int temp2 = num2.charAt(j) - '0';
                resarr[i+j+1] += temp1 * temp2;
            }
        }
        // 处理进位
        for (int i = reslen - 1; i > 0; i--){
            if (resarr[i] >= 10){
                int temp = resarr[i];
                resarr[i] = temp % 10;
                resarr[i - 1] += temp / 10;
            }
        }
        boolean flag = false;
        for (int i = 0; i < reslen; i++){
            if (flag){
                sb.append(resarr[i]);
            } else {
                if (resarr[i] != 0){
                    sb.append(resarr[i]);
                    flag = true;
                }
            }
        }

        return sb.toString();
    }
}

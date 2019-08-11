package StringAlgo;

public class ConvertIPv4 {
    public static long convertIP2Int(String str){
        long res = 0;
        StringBuilder buffer = null;
        //记录上一个遍历到的字符
        char pre = '\0';
        //记录每段子串的int值
        int subVal = 0;
        //记录当前遍历到为第几个子串
        int index = 0;

        try {
            for (int i = str.length() - 1; i >= 0; --i) {
                char cursor = str.charAt(i);
                pre = pre == '\0' ? cursor : pre;

                //每遍历到一个新的子串时，缓冲区清零
                if (null == buffer) {
                    buffer = new StringBuilder();
                }
                switch (cursor) {
                    //读取到空字符时，只记录，不做任何处理
                    case ' ': {
                        break;
                    }
                    case '.': {
                        //类似 127..0.1 127.0.0.. 的字符串都认为是非法输入
                        if (buffer.length() == 0)
                            throw new Exception();

                        //形如 127.00.0.1 的输入皆为非法输入
                        if (buffer.length() > 1 && pre == '0')
                            throw new Exception();

                        if(subVal > 255)
                            throw new Exception();

                        int multiple = (int) Math.pow(2, 8 * index++);
                        res += subVal * multiple;
                        //System.out.println("res = res + " + subVal + " x " + multiple);
                        subVal = 0;
                        buffer = null;
                        break;
                    }
                    default: {
                        //合法的IP地址应该只有 数字、空字符、分隔符三种字符
                        if (!Character.isDigit(cursor))
                            throw new Exception();

                        //读取到数字时，若前缀为空且缓冲区已有值，为非法输入 类似 17_2
                        if (pre == ' ' && buffer.length() > 0)
                            throw new Exception();

                        //合法的IPv4地址的子串最长为三位数字，超过即认为非法输入
                        if (buffer.length() == 3)
                            throw new Exception();

                        subVal += (int) Math.pow(10, buffer.length()) * (cursor - '0');
                        buffer.append(cursor);
                        break;
                    }
                }
                pre = cursor;
            }
            //最高的8位因为前缀已没有分隔符，因此需要单独处理
            if(index == 3){
                if(buffer == null || buffer.length() == 0 || subVal > 255)
                    throw new Exception();

                long multiple = (long) Math.pow(2, 8 * index);
                res += subVal * multiple;
                //System.out.println("res = " + res + " + "+ subVal + " x " + multiple);
            }
        }
        catch(Exception e){
            System.out.println("Invalid input: " + str);
            return -1;
        }

        return res;
    }
}

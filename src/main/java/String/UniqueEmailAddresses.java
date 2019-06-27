package String;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        int ret = 0;
        Set<String> uniqueEmailSet = new HashSet<>();
        for(String str : emails){
            if(uniqueEmailSet.contains(processEmail(str))){
                continue;
            }
            else{
                ret++;
                uniqueEmailSet.add(processEmail(str));
            }
        }
        return ret;
    }

    private String processEmail(String str){
        String pre = str.substring(0,str.indexOf("@"));
        String nxt = str.substring(str.indexOf("@") + 1);
        pre = pre.replace(".", "");
        if(pre.contains("+")){
            pre = pre.substring(0, pre.indexOf("+"));
        }
        return pre + "@" + nxt;
    }
}

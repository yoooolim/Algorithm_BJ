import java.util.Arrays;

public class P17686_FileNameSort3 {
    public static void main(String[] args){
        String[] str = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG", "IMG000000"};
        String[] ans = solution(str);
        for(int i=0;i<ans.length;i++) System.out.print(ans[i]+" ");
    }
    private static String[] solution(String[] files) {
        /*String str1 = "a-";
        String str2 = "b-"; //왜 a-랑 b-랑 비교하면 사전순으로 b-가 먼저일까..
        int temp = str2.compareTo(str1);*/
        String[] answer = new String[files.length];
        File[] fileTemplate = new File[files.length];
        for(int i=0;i<files.length;i++) fileTemplate[i] = classifyFile(files[i],i);
        Arrays.sort(fileTemplate);
        for(int i=0;i<files.length;i++) answer[i]=files[fileTemplate[i].idx];
        return answer;
    }
    private static String eraseFirstZero(String str){
        while(str.charAt(0)=='0'&&str.length()>1){
            str=str.substring(1,str.length());
        }
        return str;
    }
    private static File classifyFile(String file, int idx){
        File fileTemplate = new File();
        fileTemplate.idx = idx;
        int numStartIdx = 0;
        int numEndIdx = 0;
        for(int i=0;i<file.length();i++){
            if(file.charAt(i)>='0'&&file.charAt(i)<='9') {
                numStartIdx = i;
                break;
            }
        }
        fileTemplate.head = file.substring(0,numStartIdx);
        for(int i=numStartIdx;i<file.length();i++){
            if(i>=numStartIdx+5) { numEndIdx = i;break;}
            if(file.charAt(i)<'0'||file.charAt(i)>'9'){
                numEndIdx = i; break;
            }
        }
        if(numEndIdx==0) {
            fileTemplate.number = Integer.parseInt(eraseFirstZero(file.substring(numStartIdx)));
            return fileTemplate;
        }
        fileTemplate.number = Integer.parseInt(eraseFirstZero(file.substring(numStartIdx, numEndIdx)));
        return fileTemplate;
    }
    private static class File implements Comparable<File>{
        int idx;
        String head;
        int number;
        File(){ this.head = ""; this.number = -1; }

        @Override
        public int compareTo(File f){
            if(this.head.compareToIgnoreCase(f.head)<0) return -1;
            else if(this.head.compareToIgnoreCase(f.head)>0) return 1;
            else if(this.number<f.number) return -1;
            else if(this.number>f.number) return 1;
            else return 0;
        }
    }
}

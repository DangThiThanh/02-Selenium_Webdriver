package javaTester;

public class Topic_01_Data_Type {
    // kiểu dữ liệu trong java - 2 nhóm
    // I - Kiểu dữ liệu nguyên thủy (primitive)
    // Số nguyên : byte - short - int - long
    // ko có phần thập phân
    // số thực: float - double
    // ký tự : char
    //logic: boolean 
    public static void main(String args[]){
        String projectPath= System.getProperty("user.dir");
        String anh1Name="anh1.jpg";

        String anh2Name="anh2.jpg";
        String anh3Name="anh3.jpg";
        String anh1FilePath= projectPath + "\\uploadFile\\" + anh1Name;
        String anh2FilePath= projectPath + "\\uploadFile\\" + anh2Name;
        String anh3FilePath= projectPath + "\\uploadFile\\" + anh3Name;
        System.out.println( anh1FilePath  +" test ");
    }
}

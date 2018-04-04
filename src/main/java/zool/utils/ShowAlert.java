package zool.utils;

public class ShowAlert {

    public static String show(String str){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<title>Show Alert</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<script type=\"text/javascript\">");
        sb.append("alert(");
        sb.append("\"");
        sb.append(str);
        sb.append("\");");
        sb.append("</script>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

}

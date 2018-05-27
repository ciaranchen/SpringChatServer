package ChatServer.util;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.security.Principal;

public class UserPrincipal implements Principal, Cloneable, Serializable {
    //【1】小例子中最重要的身份信息是 username，该信息一次性填入，不允许修改
    private final String username;

    public UserPrincipal(String username) {
        this.username = username;
    }

    //【2】getContent() 是 Principal 接口，是主要使用的方法
    @Override
    public String getName() {
        return this.username;
    }

    //【3】hashCode() 和 equals() 即是 Principal 接口也是 Object 的接口，我们比对两个 principal 是否一直，不是比较对象的地址，而是里面的信息。同时修改 toString() 给出显示的信息
    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UserPrincipal
                && ((UserPrincipal) obj).username.equals(this.username);
    }

    @Override
    public String toString() {
        return this.username;
    }

    //【4】允许 colon
    @Override
    protected UserPrincipal clone() throws CloneNotSupportedException {
        return (UserPrincipal)super.clone();
    }

    //【5】提供两个静态方法 getPrincipal() 和 setPrincipal()，将 principal 和 session 中的某个属性对应起来，也就是真实的仍借用 session 进行数据存放。放置在 session，session 过期后，将不存在
    public static Principal getPrincipal(HttpSession session){
        return session == null ? null :
                (Principal)session.getAttribute("cn.wei.flowingflying.customer_support.user.principal");
    }

    public static void setPrincipal(HttpSession session, Principal principal){
        session.setAttribute("cn.wei.flowingflying.customer_support.user.principal", principal);
    }
}

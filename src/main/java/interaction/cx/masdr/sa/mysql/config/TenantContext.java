package interaction.cx.masdr.sa.mysql.config;
public class TenantContext {
    private static ThreadLocal<String> tenantId = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        TenantContext.tenantId.set(tenantId);
    }

    public static String getTenantId() {
        return tenantId.get();
    }

    public static void clear() {
        tenantId.remove();
    }
}

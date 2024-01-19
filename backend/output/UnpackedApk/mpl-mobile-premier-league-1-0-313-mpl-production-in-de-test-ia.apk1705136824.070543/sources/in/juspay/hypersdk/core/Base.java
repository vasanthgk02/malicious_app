package in.juspay.hypersdk.core;

public class Base {
    public static final String BASE_HTML_CONTENT = "<html>\n<head>\n    <title>Hyper OS</title>\n</head>\n<body>\n</body>\n<script>\n    window.DUIGatekeeper = JBridge;\n</script>\n<script type=\"text/javascript\">\n    var headID = document.getElementsByTagName(\"head\")[0];\n    var newScript = document.createElement('script');\n    newScript.type = 'text/javascript';\n    newScript.id = 'boot_loader';\n    var bundleLoadStart = Date.now();\n    newScript.innerHTML = JBridge.loadFileInDUI('v1-boot_loader.jsa');\n    var bundleLoadEnd = Date.now();\n    window.__osStart = Date.now();\n    var loadLatency = bundleLoadEnd - bundleLoadStart;\n    var obj = {};\n    obj[\"os_bundle_load\"] = {\"bundle_load_start\":bundleLoadStart,\"bundle_load_end\":bundleLoadEnd,\"bundle_load_latency\":loadLatency};\n    window.__osBundleLoadLogLine = obj;\n    headID.appendChild(newScript);\n</script>\n</html>";
}

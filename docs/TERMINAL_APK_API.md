## TerminalApk API

All the terminalApk related APIs are encapsulated in the class *com.pax.market.api.sdk.java.api.terminalApk.TerminalApkApi*.

**Constructors of TerminalApkApi**

```
public TerminalApkApi(String baseUrl, String apiKey, String apiSecret);
public TerminalApkApi(String baseUrl, String apiKey, String apiSecret, Locale locale);
```

**Constructor parameters description**

|Name|Type|Description|
|:---|:---|:---|
|baseUrl|String|the base url of REST API|
|apiKey|String|the apiKey of marketplace, get this key from PAXSTORE admin console, refe to chapter Apply access rights|
|apiSecret|String|apiSecret, get api secret from PAXSTORE admin console, refer to chapter Apply access rights|
|locale|Locale|the locale, the default locale is Locale.ENGLISH, the language of message and errors in return object depend on locale|


### Create terminalApk

Create terminalApk API allow the thirdparty system create a terminalApk.


**API**

```
public Result<String> createTerminalApk(CreateTerminalApkRequest createTerminalApkRequest)
```

**Input parameter(s) description**  


|Parameter Name|Type|Nullable|Description|
|:---|:---|:---|:---|
|createTerminalApkRequest|CreateTerminalApkRequest|false|The create request object. The structure shows below.|


Structure of class TerminalCreateRequest

|Property Name|Type|Nullable|Description|
|:---|:---|:---|:---|
|tid|String|true|The tid of terminal|
|serialNo|String|true|The serial number of terminal|
|packageName|String|false|The package name which indicate the application you want to push to the terminal|
|version|String|true|The version name of application which you want to push, if it is blank API will use the latest version|
|templateName|String|true|The template file name of paramter application. The template file name can be found in the detail of the parameter application. If user want to push more than one template the please use &#124; to concact the different template file names like tempate1.xml&#124;template2.xml&#124;template3.xml, the max size of template file names is 10.|
|parameters|Map&lt;String, String&gt;|false|The parameter key and value, the key the the PID in template|

Note: tid and serialNo cannot be empty at same time.


**Sample codes**

```
TerminalApkApi terminalApkApi = new TerminalApkApi("https://api.whatspos.com/p-market-api", "RCA9MDH6YN3WSSGPW6TJ", "TUNLDZVZECHNKZ4FW07XFCKN2W0N8ZDEA5ENKZYN");
CreateTerminalApkRequest createTerminalApkRequest = new CreateTerminalApkRequest();
createTerminalApkRequest.setTid("ABC09098989");
createTerminalApkRequest.setPackageName("com.baidu.map");
createTerminalApkRequest.setTemplateName("template_map");
Map<String, String> parameters = new HashMap<String, String>();
parameters.put("PID.locationCode", "cn_js_sz");
parameters.put("PID.showtraffic", "true");
createTerminalApkRequest.setParameters(parameters);
 terminalApkApi.createTerminalApk(createTerminalApkRequest);
```

**Client side validation failed sample result(JSON formatted)**

```
{
	"businessCode": -1,
	"validationErrors": ["The property serialNo and tid in createTerminalApkRequest cannot be blank at same time!"]
}
```

**Server side validation failed sample result(JSON formatted)**

```
{
	"businessCode": 2028,
	"message": "TerminalApk not found"
}
```

**Successful sample result(JSON formatted)**

```
{
	"businessCode": 0
}
```


**Possible validation errors**

> <font color=red>Parameter createTerminalApkRequest cannot be null!</font>  
> <font color=red>The property parameters of createTerminalApkRequest cannot be empty!</font>  
> <font color=red>The property serialNo and tid in createTerminalApkRequest cannot be blank at same time!</font> 
> <font color=red>packageName:may not be empty</font> 
> <font color="red">The max size of template names is 10!</font>


**Possible business codes**

|Business Code|Message|Description|
|:---|:---|:---|
|2028|Terminal not found|Please check the value of tid or serialNo|
|2029|Apk not found|Cannot find apk by packagename and version|
|2030|Parameter template not found|The given template name(s) not exist in system|
|13100|Invalid application parameter variables||
|2026|Tid and serialNo cannot empty at same time||
|2027|Package name cannot be empty||
|2001|Terminal app not found||
|2000|Terminal app status is invalid||
|9306|App is not available||
|2022|Same version of pending terminal app already exists||
|2023|Same version of active terminal app already exists||
|1905|Terminal task app parameter is invalid||
|13100|Invalid application parameter variables||
|1111|Selected parameter templates exceeded the max limit||
|2031|Template name cannot be empty|&nbsp;|


### Suspend terminalApk

Suspend terminalApk API allow the thirdparty system suspend terminalApk.


**API**

```
public Result<String> suspendTerminalApk(UpdateTerminalApkRequest suspendTerminalApkRequest)
```

**Input parameter(s) description**  


|Parameter Name|Type|Nullable|Description|
|:---|:---|:---|:---|
|suspendTerminalApkRequest|UpdateTerminalApkRequest|false|The suspend request object. The structure shows below.|


Structure of class UpdateTerminalApkRequest

|Property Name|Type|Nullable|Description|
|:---|:---|:---|:---|
|tid|String|true|The tid of terminal|
|serialNo|String|true|The serial number of terminal|
|packageName|String|false|The package name which indicate the application you want to suspend the terminal push task|

Note: tid and serialNo cannot be empty at same time.


**Sample codes**

```
TerminalApkApi terminalApkApi = new TerminalApkApi("https://api.whatspos.com/p-market-api", "RCA9MDH6YN3WSSGPW6TJ", "TUNLDZVZECHNKZ4FW07XFCKN2W0N8ZDEA5ENKZYN");
UpdateTerminalApkRequest suspendTerminalApkRequest = new UpdateTerminalApkRequest();
suspendTerminalApkRequest.setTid("ABC09098989");
suspendTerminalApkRequest.setPackageName("com.baidu.map");
terminalApkApi.suspendTerminalApk(suspendTerminalApkRequest);
```

**Client side validation failed sample result(JSON formatted)**

```
{
	"businessCode": -1,
	"validationErrors": ["The property serialNo and tid in suspendTerminalApkRequest cannot be blank at same time!"]
}
```

**Server side validation failed sample result(JSON formatted)**

```
{
	"businessCode": 2038,
	"message": "Unfinished terminal push app not found"
}
```

**Successful sample result(JSON formatted)**

```
{
	"businessCode": 0
}
```


**Possible validation errors**

> <font color=red>Parameter suspendTerminalApkRequest cannot be null!</font>  
> <font color=red>The property serialNo and tid in suspendTerminalApkRequest cannot be blank at same time!</font> 
> <font color=red>packageName:may not be empty</font>


**Possible business codes**

|Business Code|Message|Description|
|:---|:---|:---|
|2028|Terminal not found|Please check the value of tid or serialNo|
|2029|Apk not found|Cannot find apk by packagename and version|
|2026|Tid and serialNo cannot empty at same time||
|2027|Package name cannot be empty||
|2038|Unfinished terminal push app not found||


### Uninstall terminalApk

Uninstall terminalApk API allow the thirdparty system uninstall app from terminal.


**API**

```
public Result<String> uninstallTerminalApk(UpdateTerminalApkRequest uninstallTerminalApkRequest)
```

**Input parameter(s) description**  


|Parameter Name|Type|Nullable|Description|
|:---|:---|:---|:---|
|uninstallTerminalApkRequest|UpdateTerminalApkRequest|false|The suspend request object. The structure shows below.|


Structure of class UpdateTerminalApkRequest

|Property Name|Type|Nullable|Description|
|:---|:---|:---|:---|
|tid|String|true|The tid of terminal|
|serialNo|String|true|The serial number of terminal|
|packageName|String|false|The package name which indicate the application you want to suspend the terminal push task|

Note: tid and serialNo cannot be empty at same time.


**Sample codes**

```
TerminalApkApi terminalApkApi = new TerminalApkApi("https://api.whatspos.com/p-market-api", "RCA9MDH6YN3WSSGPW6TJ", "TUNLDZVZECHNKZ4FW07XFCKN2W0N8ZDEA5ENKZYN");
UpdateTerminalApkRequest uninstallTerminalApkRequest = new UpdateTerminalApkRequest();
uninstallTerminalApkRequest.setTid("ABC09098989");
uninstallTerminalApkRequest.setPackageName("com.baidu.map");
terminalApkApi.uninstallTerminalApk(uninstallTerminalApkRequest);
```

**Client side validation failed sample result(JSON formatted)**

```
{
	"businessCode": -1,
	"validationErrors": ["The property serialNo and tid in uninstallTerminalApkRequest cannot be blank at same time!"]
}
```

**Server side validation failed sample result(JSON formatted)**

```
{
	"businessCode": 2037,
	"message": "This app is not installed on the terminal"
}
```

**Successful sample result(JSON formatted)**

```
{
	"businessCode": 0
}
```


**Possible validation errors**

> <font color=red>Parameter uninstallTerminalApkRequest cannot be null!</font>  
> <font color=red>The property serialNo and tid in uninstallTerminalApkRequest cannot be blank at same time!</font> 
> <font color=red>packageName:may not be empty</font>


**Possible business codes**

|Business Code|Message|Description|
|:---|:---|:---|
|2028|Terminal not found|Please check the value of tid or serialNo|
|2029|Apk not found|Cannot find apk by packagename and version|
|2026|Tid and serialNo cannot empty at same time||
|2027|Package name cannot be empty||
|2037|This app is not installed on the terminal||
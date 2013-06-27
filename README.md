EJB3Playground
==============
This is a Eclipse Workspace containing some projects which can be used to test EJB3.

`SessionTestEAR` is a Enterprise Archive containing the `SessionTest` Module which contains two
Session beans. They support a `throwException()` method which will throw an `RuntimeException` and
can be used to inspect the callstack (for Container and EJB Interceptors).  SessionTestClient is an 
Utility JAR containing the Remote Interface and `SessionTestCaller` a stand alone appclient.

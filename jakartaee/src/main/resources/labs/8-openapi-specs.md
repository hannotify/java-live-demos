# LAB 8: OpenAPI Specs

Now we want to add OpenAPI documentation, so that our end users can understand our REST API without having to read Java code.

1. Read up on Swagger Annotations at https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations.
2. Try out a few of them. `@OpenApiDefinition`, `@Operation` and `@Parameter` are good candidates, but you can try some of the other ones as well.
3. Navigate to http://localhost:9080/openapi/ui/ to see the result of your additions.

The reason this works is because OpenLiberty automatically incorporates a Swagger UI in its setup.
Not all EE Containers do that.
If you ever encounter an environment where you miss the Swagger UI, you can always paste an `openapi.yaml` into the editor at https://editor.swagger.io.
The `openapi.yaml` that OpenLiberty generates can be found at http://localhost:9080/openapi/ui/. 

4. Try this out.
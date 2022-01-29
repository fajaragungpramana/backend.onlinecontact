# Backend - Online Contact
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>
Simple application for save contact with authentication.

## Stack Information
```bash
> Java Spring Boot
> MongoDB
> Docker (NGINX, MONGODB)
```

## Application Flow
<a href="url"><img src="https://github.com/fajaragungpramana/assets/blob/master/Backend-OnlineContact/Screenshot%20from%202022-01-29%2019-09-24.png" align="left" height="500" width="1000" ></a>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

## API SPEC
This is all of api spec in this application.
```bash
BASE_URL        : https://api.domain.example.com/
AUTHENTICATION  : JWT (JSON WEB TOKEN)
REQUEST         : JSON - MULTIPART - PATH - PARAMETER
RESPONSE        : JSON
```

### API Version
This api to get data latest app version. information
```bash
URL_REQUEST     : version
AUTHENTICATION  : NULL
METHOD          : GET
REQUEST         : NULL
RESPONSE        : JSON
```
Response Example `HTTP_CODE 200`:
```json
{
  "code" : null,
  "message" : "This is the latest app version.",
  "data" : {
    "version_name" : "1.0.0",
    "version_code" : 1
  }
}
```

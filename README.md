# FDIC Institution Search Function

Micronaut Framework `@FunctionBean` deployed as a AWS Lambda Function that receives requests via an AWS API Gateway and proxies the received inputs to the [FDIC Bank Data API](https://banks.data.fdic.gov/docs/).

```
curl -X GET https://6axu70yfr6.execute-api.us-east-1.amazonaws.com/default/FdicInstitutionSearch\?q\=Wells\*
```
### Exporting Data From Mongodb Collection
```
mongoexport --uri "<URL>" --collection <CollectionName> --type=csv --out text.csv --fields "<FieldsName>"
```

### Importing Data Into Mongodb Collection
```
mongoimport --uri "<URL>" --collection <CollectionName> --type=csv --file text.csv --headerline
```

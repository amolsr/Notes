mongoexport --uri "<URL>" --collection <CollectionName> --type=csv --out text.csv --fields "<FieldsName>"

mongoimport --uri "<URL>" --collection <CollectionName> --type=csv --file text.csv --headerline

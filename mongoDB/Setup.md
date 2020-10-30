Launch a mongod instance in terminal with a configuration file:

Write the configuration file. There should be an empty configuration file in your IDE File Editor, where you can specify options in YAML.

```
storage:
  dbPath: "/data/db"
systemLog:
  destination: file
  path: "/data/logs"
replication:
  replSetName: "M103"
net:
  bindIp: "127.0.0.1,192.168.103.100"
security:
  keyFile: "/data/keyfile"
processManagement:
  fork: true
```

As a reminder, here are the requirements of your mongod instance:

run on port 27000
authentication is enabled
When your config file is complete, launch mongod with the --config command line option:
```
mongod --config mongod.conf --port 27000 --auth
```
or using the -f option:
```
mongod -f mongod.conf --port 27000 --auth
```
Once mongod is running, open a new Terminal window and use the following command to create an admin user. You will need to create this user in order to validate your work.

```
mongo admin --host localhost:27000 --eval '
  db.createUser({
    user: "m103-admin",
    pwd: "m103-pass",
    roles: [
      {role: "root", db: "admin"}
    ]
  })
'
```

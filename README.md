# DBMidterm_submit

```
- DBMidterm
- start.sh
- insert.sh
- README.md
- 实验报告.md
- departments.csv
- dept_emp.csv
- dept_manager.csv
- employees.csv
- titles.csv
```

### start.sh

需要占用端口8080和3306

### insert.sh

本脚本调用了RESTFUL接口，因此运行此脚本之前需要先运行start.sh
大约需要4min

脚本使用了“curl”指令

数据文件放在根目录

### api接口规范

#### departments

add:

body示例：

```
{
        "rows":[
        	{"deptNo": "0001","deptName": "0001name"},
        	{"deptNo": "0002","deptName": "0002name"}
        ]
}
```

update:

body示例：

```
{
    "deptNo": "d001",
    "deptName": "d001new"
}
```

remove：

参数：deptNo

get：

参数：deptNo

#### dept_emp

add：

body示例：

```
{
        "rows":[
        	{
        		"empNo": 10001,
        		"deptNo": "d005",
       			"fromDate": "1986-06-26",
        		"toDate": "9999-01-01"
    		},
        	{
        		"empNo": 10002,
        		"deptNo": "d004",
       			"fromDate": "1986-06-26",
        		"toDate": "9999-01-01"
    		}
        ]
}
```

update:

body示例：

```
{
  "empNo": 10001,
  "deptNo": "d005",
  "fromDate": "1986-06-26",
  "toDate": "8888-01-01"
}
```

remove：

参数：empNo，deptNo

get：

参数：empNo，deptNo

#### dept_manager

add：

body示例：

```
{
        "rows":[
        	{
    			"empNo": 10004,
    			"deptNo": "d002",
    			"fromDate": "1985-01-01",
    			"toDate": "9999-01-01"
			},
        	{
        		"empNo": 10001,
    			"deptNo": "d003",
    			"fromDate": "1985-01-01",
    			"toDate": "9999-01-01"
    		}
        ]
}
```

update:

body示例：

```
{
	"empNo": 10004,
	"deptNo": "d002",
	"fromDate": "1985-01-01",
	"toDate": "9999-01-01"
}
```

remove：

参数：empNo，deptNo

get：

参数：empNo，deptNo

#### employee

add：

body示例：

```
{
        "rows":[
        	{
  				"empNo": 0,
  				"birthDate": "string",
  				"firstName": "string",
  				"lastName": "string",
  				"gender": "string",
  				"hireDate": "string"
			},
        	{
  				"empNo": 0,
  				"birthDate": "string",
  				"firstName": "string",
  				"lastName": "string",
  				"gender": "string",
  				"hireDate": "string"
    		}
        ]
}
```

update:

body示例：

```
{
  				"empNo": 0,
  				"birthDate": "string",
  				"firstName": "string",
  				"lastName": "string",
  				"gender": "string",
  				"hireDate": "string"
}
```

remove：

参数：empNo

getByEmp：

参数：empNo

getByFirstName：

参数：firstName

#### title

add：

body示例：

```
{
        "rows":[
        	{
    			"empNo": 10001,
    			"toDate": "9999-01-01",
    			"fromDate": "1985-01-01",
    			"title": "title1"
			},
        	{
    			"empNo": 10002,
    			"toDate": "9999-01-01",
    			"fromDate": "1985-01-01",
    			"title": "title2"
    		}
        ]
}
```

update:

body示例：

```
{
    			"empNo": 10001,
    			"toDate": "9999-01-01",
    			"fromDate": "1985-01-01",
    			"title": "title1"
}
```

remove：

参数：empNo，title，fromDate

get：

参数：empNo，title，fromDate

/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.user.core.hybrid;

public class HybridJDBCConstants {

    public static final String GET_ROLE_LIST_OF_USER = "GetRoleListOfInternalUserSQL";
    public static final String GET_IS_ROLE_EXIST_LIST_OF_USER = "GetIsRoleExistFromRoleListOfInternalUserSQL";

    public static final String GET_ROLE_LIST_OF_USERS = "GetRoleListOfInternalUsersSQL";

    public static final String ADD_ROLE_SQL = "INSERT INTO UM_HYBRID_ROLE (UM_ROLE_NAME, UM_TENANT_ID) VALUES (?, ?)";
    public static final String DELETE_ROLE_SQL = "DELETE FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME = ? AND UM_TENANT_ID=?";
    public static final String ON_DELETE_ROLE_REMOVE_USER_ROLE_SQL = "DELETE FROM UM_HYBRID_USER_ROLE WHERE " +
            "UM_ROLE_ID=(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME = ? AND " +
            "UM_TENANT_ID=?) AND UM_TENANT_ID=?";
    public static final String GET_ROLE_ID = "SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME =? " +
            "AND UM_TENANT_ID=?";

    //a single role name - multiple user names
    public static final String ADD_USER_TO_ROLE_SQL = "INSERT INTO UM_HYBRID_USER_ROLE (UM_USER_NAME, UM_ROLE_ID, " +
            "UM_TENANT_ID, UM_DOMAIN_ID) VALUES (?,(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?), ?, " +
            "(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?))";

    public static final String ADD_USER_TO_ROLE_SQL_MSSQL = "INSERT INTO UM_HYBRID_USER_ROLE (UM_USER_NAME, UM_ROLE_ID, " +
            "UM_TENANT_ID,  UM_DOMAIN_ID) SELECT (?),(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?), (?), " +
            "(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String REMOVE_USER_FROM_ROLE_SQL = "DELETE FROM UM_HYBRID_USER_ROLE WHERE UM_USER_NAME=? AND " +
            "UM_ROLE_ID=(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?) AND UM_TENANT_ID=? " +
            "AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String REMOVE_USER_FROM_ROLE_SQL_CASE_INSENSITIVE = "DELETE FROM UM_HYBRID_USER_ROLE WHERE " +
            "LOWER(UM_USER_NAME)=LOWER(?) AND UM_ROLE_ID=(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?) AND UM_TENANT_ID=? " +
            "AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    //a single user name - multiple role names
    public static final String ADD_ROLE_TO_USER_SQL = "INSERT INTO UM_HYBRID_USER_ROLE (UM_ROLE_ID, UM_USER_NAME, " +
            "UM_TENANT_ID, UM_DOMAIN_ID) VALUES ((SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?), ?, ?," +
            "(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?))";

    public static final String ADD_ROLE_TO_USER_SQL_MSSQL = "INSERT INTO UM_HYBRID_USER_ROLE (UM_ROLE_ID, UM_USER_NAME, " +
            "UM_TENANT_ID,  UM_DOMAIN_ID) SELECT (SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?), (?), (?)," +
            "(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";


    //openedge
    //TODO: change to have domain id
    public static final String ADD_USER_TO_ROLE_SQL_OPENEDGE = "INSERT INTO UM_HYBRID_USER_ROLE (UM_USER_NAME, UM_ROLE_ID, UM_TENANT_ID) SELECT ?, UM_ID, ? FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?";
    public static final String ADD_ROLE_TO_USER_SQL_OPENEDGE = "INSERT INTO UM_HYBRID_USER_ROLE (UM_ROLE_ID, UM_USER_NAME, UM_TENANT_ID) SELECT UM_ID, ?, ? FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?";

    public static final String REMOVE_ROLE_FROM_USER_SQL = "DELETE FROM UM_HYBRID_USER_ROLE WHERE UM_ROLE_ID=" +
            "(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?) AND " +
            "UM_USER_NAME=? AND UM_TENANT_ID=? AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String REMOVE_ROLE_FROM_USER_SQL_CASE_INSENSITIVE = "DELETE FROM UM_HYBRID_USER_ROLE WHERE " +
            "UM_ROLE_ID=(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?) AND " +
            "LOWER(UM_USER_NAME)=LOWER(?) AND UM_TENANT_ID=? AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String GET_ROLES =
            "SELECT UM_ROLE_NAME FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME LIKE ? AND UM_TENANT_ID=?";
    public static final String GET_INTERNAL_ROLES =
            "SELECT UM_ROLE_NAME FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME LIKE ? AND NOT UM_ROLE_NAME LIKE ? AND " +
                    "UM_TENANT_ID=?";
    public static final String GET_INTERNAL_ROLES_DB2 =
            "SELECT UM_ROLE_NAME FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME LIKE ? AND NOT(UM_ROLE_NAME LIKE ?) AND " +
                    "UM_TENANT_ID=?";
    public static final String GET_ROLES_PAGINATED = "SELECT UM_ROLE_NAME FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME LIKE" +
            " ? AND UM_TENANT_ID=? ORDER BY UM_ROLE_NAME ASC LIMIT ? OFFSET ?";
    public static final String GET_ROLES_PAGINATED_DB2 = "SELECT UM_ROLE_NAME FROM (SELECT ROW_NUMBER() OVER " +
            "(ORDER BY UM_ROLE_NAME) AS rn, p.*  FROM (SELECT DISTINCT UM_ROLE_NAME  FROM UM_HYBRID_ROLE U " +
            "WHERE U.UM_ROLE_NAME LIKE ? AND U.UM_TENANT_ID = ?) AS p) WHERE rn BETWEEN ? AND ?";
    public static final String GET_ROLES_PAGINATED_MSSQL = "SELECT UM_ROLE_NAME FROM (SELECT UM_ROLE_NAME," +
            "UM_TENANT_ID, ROW_NUMBER() OVER (ORDER BY UM_ROLE_NAME) AS RowNum FROM UM_HYBRID_ROLE) AS P WHERE P" +
            ".UM_ROLE_NAME LIKE ? AND P.UM_TENANT_ID= ? AND P.RowNum BETWEEN ? AND ?";
    public static final String GET_ROLES_PAGINATED_ORACLE = "SELECT UM_ROLE_NAME FROM (SELECT UM_ROLE_NAME," +
            " UM_TENANT_ID, rownum AS rnum FROM (SELECT UM_ROLE_NAME, UM_TENANT_ID FROM UM_HYBRID_ROLE ORDER BY " +
            "UM_ROLE_NAME) WHERE UM_ROLE_NAME LIKE ? AND UM_TENANT_ID=? AND rownum <= ?) WHERE  rnum > ?";
    public static final String GET_INTERNAL_ROLES_PAGINATED = "SELECT UM_ROLE_NAME FROM UM_HYBRID_ROLE WHERE " +
            "UM_ROLE_NAME LIKE" +
            " ? AND UM_TENANT_ID=? AND NOT UM_ROLE_NAME LIKE ? ORDER BY UM_ROLE_NAME ASC LIMIT ? OFFSET ?";
    public static final String GET_INTERNAL_ROLES_PAGINATED_DB2 =
            "SELECT UM_ROLE_NAME FROM (SELECT ROW_NUMBER() OVER (ORDER BY UM_ROLE_NAME) AS rn, p.*  FROM " +
                    "(SELECT DISTINCT UM_ROLE_NAME  FROM UM_HYBRID_ROLE U WHERE U.UM_ROLE_NAME LIKE ? AND " +
                    "U.UM_TENANT_ID = ? AND NOT(UM_ROLE_NAME LIKE ?)) AS p) WHERE rn BETWEEN ? AND ?";
    public static final String GET_INTERNAL_ROLES_PAGINATED_MSSQL = "SELECT UM_ROLE_NAME FROM (SELECT UM_ROLE_NAME," +
            "UM_TENANT_ID, ROW_NUMBER() OVER (ORDER BY UM_ROLE_NAME) AS RowNum FROM UM_HYBRID_ROLE) AS P WHERE P" +
            ".UM_ROLE_NAME LIKE ? AND P.UM_TENANT_ID= ? AND NOT UM_ROLE_NAME LIKE ? AND P.RowNum BETWEEN ? AND ?";
    public static final String GET_INTERNAL_ROLES_PAGINATED_ORACLE = "SELECT UM_ROLE_NAME FROM (SELECT UM_ROLE_NAME," +
            " UM_TENANT_ID, rownum AS rnum FROM (SELECT UM_ROLE_NAME, UM_TENANT_ID FROM UM_HYBRID_ROLE ORDER BY " +
            "UM_ROLE_NAME) WHERE UM_ROLE_NAME LIKE ? AND UM_TENANT_ID=? AND NOT UM_ROLE_NAME LIKE ? AND rownum <= ?) " +
            "WHERE  rnum > ?";
    public static final String COUNT_INTERNAL_ROLES_SQL = "SELECT COUNT(UM_ID) AS RESULT FROM UM_HYBRID_ROLE WHERE " +
            "UM_ROLE_NAME LIKE ? AND NOT UM_ROLE_NAME LIKE ? AND UM_TENANT_ID = ?";
    public static final String COUNT_INTERNAL_ROLES_SQL_DB2 = "SELECT COUNT(UM_ID) AS RESULT FROM UM_HYBRID_ROLE " +
            "WHERE NOT(UM_ROLE_NAME LIKE ?) AND UM_ROLE_NAME LIKE ? AND UM_TENANT_ID = ?";
    public static final String COUNT_ROLES_SQL =
            "SELECT COUNT(UM_ID) AS RESULT FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME " +
                    "LIKE ? AND UM_TENANT_ID = ?";
    public static final String GET_USER_LIST_OF_ROLE_SQL = "SELECT UM_USER_NAME, UM_DOMAIN_NAME FROM UM_HYBRID_USER_ROLE, UM_DOMAIN WHERE " +
            "UM_ROLE_ID=(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?) AND UM_HYBRID_USER_ROLE.UM_TENANT_ID=? " +
            "AND UM_HYBRID_USER_ROLE.UM_DOMAIN_ID=UM_DOMAIN.UM_DOMAIN_ID";
    //public static final String GET_ROLE_LIST_OF_USER_SQL = "SELECT UM_ROLE_NAME FROM UM_HYBRID_USER_ROLE, UM_HYBRID_ROLE WHERE UM_USER_NAME=? AND UM_HYBRID_USER_ROLE.UM_ROLE_ID=UM_HYBRID_ROLE.UM_ID";

    public static final String GET_ROLE_LIST_OF_USER_SQL = "SELECT UM_ROLE_NAME FROM UM_HYBRID_USER_ROLE, " +
            "UM_HYBRID_ROLE WHERE UM_USER_NAME=? AND UM_HYBRID_USER_ROLE.UM_ROLE_ID=UM_HYBRID_ROLE.UM_ID AND " +
            "UM_HYBRID_USER_ROLE.UM_TENANT_ID=? AND UM_HYBRID_ROLE.UM_TENANT_ID=? AND UM_HYBRID_USER_ROLE.UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN " +
            "WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";
    public static final String GET_ROLE_OF_USER_SQL = "SELECT UM_ROLE_NAME FROM UM_HYBRID_USER_ROLE, "
            + "UM_HYBRID_ROLE WHERE UM_USER_NAME=? AND UM_HYBRID_USER_ROLE.UM_ROLE_ID=UM_HYBRID_ROLE.UM_ID AND "
            + "UM_HYBRID_USER_ROLE.UM_TENANT_ID=? AND UM_HYBRID_ROLE.UM_TENANT_ID=? AND "
            + "UM_HYBRID_USER_ROLE.UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND "
            + "UM_DOMAIN_NAME=?) AND UM_ROLE_NAME LIKE ?";

    public static final String GET_USER_ROLE_NAME_SQL = "SELECT UM_ROLE_NAME FROM UM_HYBRID_USER_ROLE, "
            + "UM_HYBRID_ROLE WHERE UM_USER_NAME=? AND UM_HYBRID_USER_ROLE.UM_ROLE_ID=UM_HYBRID_ROLE.UM_ID AND "
            + "UM_HYBRID_USER_ROLE.UM_TENANT_ID=? AND UM_HYBRID_ROLE.UM_TENANT_ID=? AND "
            + "UM_HYBRID_USER_ROLE.UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND "
            + "UM_DOMAIN_NAME=?) AND UM_ROLE_NAME=?";

    public static final String GET_INTERNAL_ROLE_LIST_OF_USERS_SQL = "SELECT UM_USER_NAME, UM_ROLE_NAME FROM "
            + "UM_HYBRID_USER_ROLE, UM_HYBRID_ROLE WHERE UM_USER_NAME IN (?) AND UM_HYBRID_USER_ROLE"
            + ".UM_ROLE_ID=UM_HYBRID_ROLE.UM_ID AND UM_HYBRID_USER_ROLE.UM_TENANT_ID=? AND UM_HYBRID_ROLE"
            + ".UM_TENANT_ID=? AND UM_HYBRID_USER_ROLE.UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE "
            + "UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String IS_USER_IN_ROLE_SQL = "SELECT UM_ROLE_ID FROM UM_HYBRID_USER_ROLE WHERE UM_USER_NAME=? " +
            "AND UM_ROLE_ID=(SELECT UM_ID FROM UM_HYBRID_ROLE WHERE UM_ROLE_NAME=? AND UM_TENANT_ID=?) AND UM_TENANT_ID=?" +
            "AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String REMOVE_USER_SQL = "DELETE FROM UM_HYBRID_USER_ROLE WHERE UM_USER_NAME=? AND UM_TENANT_ID=? " +
            "AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String REMOVE_USER_SQL_CASE_INSENSITIVE = "DELETE FROM UM_HYBRID_USER_ROLE WHERE " +
            "LOWER(UM_USER_NAME)=LOWER(?) AND UM_TENANT_ID=? AND UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)";

    public static final String UPDATE_ROLE_NAME_SQL = "UPDATE UM_HYBRID_ROLE set UM_ROLE_NAME=? WHERE UM_ROLE_NAME = ? AND UM_TENANT_ID=?";

    public static final String ADD_REMEMBERME_VALUE_SQL = "INSERT INTO UM_HYBRID_REMEMBER_ME (UM_USER_NAME, UM_COOKIE_VALUE, UM_CREATED_TIME, UM_TENANT_ID) VALUES (?,?,?,?)";

    public static final String UPDATE_REMEMBERME_VALUE_SQL = "UPDATE UM_HYBRID_REMEMBER_ME SET UM_COOKIE_VALUE=?, UM_CREATED_TIME=? WHERE UM_USER_NAME=? AND UM_TENANT_ID=?";

    public static final String GET_REMEMBERME_VALUE_SQL = "SELECT UM_COOKIE_VALUE, UM_CREATED_TIME FROM UM_HYBRID_REMEMBER_ME WHERE UM_USER_NAME=? AND UM_TENANT_ID=?";
}

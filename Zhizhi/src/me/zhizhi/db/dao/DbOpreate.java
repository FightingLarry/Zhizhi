package me.zhizhi.db.dao;

import android.content.ContentValues;
import android.database.Cursor;

public interface DbOpreate {

    /**
     * Query the given URL, returning a {@link Cursor} over the result set.
     *
     * @param columns A list of which columns to return. Passing null will
     *        return all columns, which is discouraged to prevent reading
     *        data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted
     *        as an SQL WHERE clause (excluding the WHERE itself). Passing
     *        null will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be
     *        replaced by the values from selectionArgs, in order that they
     *        appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an
     *        SQL GROUP BY clause (excluding the GROUP BY itself). Passing
     *        null will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the
     *        cursor, if row grouping is being used, formatted as an SQL
     *        HAVING clause (excluding the HAVING itself). Passing null
     *        will cause all row groups to be included, and is required
     *        when row grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY
     *        clause (excluding the ORDER BY itself). Passing null will use
     *        the default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *        formatted as LIMIT clause. Passing null denotes no LIMIT
     *        clause.
     * @return A {@link Cursor} object, which is positioned before the
     *         first entry. Note that {@link Cursor}s are not synchronized,
     *         see the documentation for more details.
     * @see Cursor
     */
    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit);

    /**
     * Convenience method for updating rows in the database.
     *
     * @param values a map from column names to new column values. null is
     *        a valid value that will be translated to NULL.
     * @param whereClause the optional WHERE clause to apply when updating.
     *        Passing null will update all rows.
     * @return the number of rows affected
     */
    public int update(ContentValues values, String whereClause, String[] whereArgs);

    /**
     * Convenience method for deleting rows in the database.
     *
     * @param whereClause the optional WHERE clause to apply when deleting.
     *        Passing null will delete all rows.
     * @return the number of rows affected if a whereClause is passed in, 0
     *         otherwise. To remove all rows and get a count pass "1" as
     *         the whereClause.
     */
    public int delete(String whereClause, String[] whereArgs);

    /**
     * Convenience method for inserting a row into the database.
     *
     * @param nullColumnHack optional; may be <code>null</code>. SQL
     *        doesn't allow inserting a completely empty row without naming
     *        at least one column name. If your provided
     *        <code>values</code> is empty, no column names are known and
     *        an empty row can't be inserted. If not set to null, the
     *        <code>nullColumnHack</code> parameter provides the name of
     *        nullable column name to explicitly insert a NULL into in the
     *        case where your <code>values</code> is empty.
     * @param values this map contains the initial column values for the
     *        row. The keys should be the column names and the values the
     *        column values
     * @return the row ID of the newly inserted row, or -1 if an error
     *         occurred
     */
    public long insert(String nullColumnHack, ContentValues values);

}

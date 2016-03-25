package ioayman.github.com.tadart2016.data.db;

import android.provider.BaseColumns;

/**
 * [3/25/16:14:02]
 *
 * @author @IOAyman
 */
public interface SQL_STRUCTURE {
    interface STATS_TABLE extends BaseColumns {
        String NAME = "STATS";
        String SQL_CREATE = String.format(
                "CREATE TABLE %s (%s %s, %s %s)",
                NAME,
                COLUMN_ID.NAME, COLUMN_ID.TYPE,
                COLUMN_HITS.NAME, COLUMN_HITS.TYPE
        );
        String SQL_DROP = String.format("DROP IF EXISTS %s", NAME);

        String SQL_LIKE = String.format(
                "UPDATE %s SET %s = %s + 1 WHERE %s = ? ",
                NAME, COLUMN_HITS.NAME, COLUMN_HITS.NAME, COLUMN_ID.NAME
        );

        interface COLUMN_ID {
            String NAME = "IMAGE_ID";
            String TYPE = "integer";
        }

        interface COLUMN_HITS {
            String NAME = "HITS";
            String TYPE = "integer";
        }
    }
}

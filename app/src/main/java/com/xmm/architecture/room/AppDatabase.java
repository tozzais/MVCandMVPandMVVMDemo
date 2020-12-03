package com.xmm.architecture.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();


    private static volatile AppDatabase INSTANCE;

    private static final String DB_NAME = "database-name";

    /**
     * 关于AppDataBase 的使用：
     * 1）如果database的版本号不变。app操作数据库表的时候会直接crash掉。(错误的做法)
     * 2）如果增加database的版本号。但是不提供Migration。app操作数据库表的时候会直接crash掉。（错误的做法）
     * 3）如果增加database的版本号。同时启用fallbackToDestructiveMigration。这个时候之前的数据会被清空掉。
     * 如下fallbackToDestructiveMigration()设置。(不推荐的做法)
     */
    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            , AppDatabase.class, DB_NAME)
                            // 设置是否允许在主线程做查询操作
                            .allowMainThreadQueries()
                            // 设置数据库升级(迁移)的逻辑
//                            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                            // setJournalMode(@NonNull JournalMode journalMode)  设置数据库的日志模式
                            // 设置迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
                            // .fallbackToDestructiveMigration() 会清理表中的数据 ，不建议这样做
                            //设置从某个版本开始迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
                            //.fallbackToDestructiveMigrationFrom(int... startVersions);
                            .addCallback(new RoomDatabase.Callback() {
                                // 进行数据库的打开和创建监听
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                }

                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                }
                            })
                            //默认值是FrameworkSQLiteOpenHelperFactory，设置数据库的factory。
                            // 比如我们想改变数据库的存储路径可以通过这个函数来实现
                            // .openHelperFactory(SupportSQLiteOpenHelper.Factory factory);
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 数据库版本 1->2 user表格新增了age列
     */
    private final static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE User ADD COLUMN age integer");
        }
    };

    /**
     * 数据库版本 2->3 新增book表格
     */
    private final static Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `userId` INTEGER, 'time' INTEGER)");
        }
    };
}


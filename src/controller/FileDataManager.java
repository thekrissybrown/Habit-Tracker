package controller;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Manages persistence of habit data using file storage.
 * @param <T> The type of data being managed
 */
public class FileDataManager<T> implements DataPersistence<T> {
    private static final String DEFAULT_DATA_DIRECTORY = "data";
    private static final String FILE_EXTENSION = ".json";
    
    private final Path storagePath;
    private final Class<T> dataType;
    
    /**
     * Creates a new FileDataManager with specified storage path and data type.
     *
     * @param storagePath the directory path for data storage
     * @param dataType the class of data being managed
     */
    public FileDataManager(Path storagePath, Class<T> dataType) {
        this.storagePath = storagePath;
        this.dataType = dataType;
    }
    
    /**
     * Creates a new FileDataManager with default storage path.
     *
     * @param dataType the class of data being managed
     */
    public FileDataManager(Class<T> dataType) {
        this(Path.of(DEFAULT_DATA_DIRECTORY), dataType);
    }
    
    @Override
    public void saveData(T data) throws IOException {
        // Implementation details
    }
    
    @Override
    public T loadData() throws IOException {
        // Implementation details
        return null;
    }
}

/**
 * Interface defining data persistence operations.
 *
 * @param <T> The type of data being persisted
 */
interface DataPersistence<T> {
    void saveData(T data) throws IOException;
    T loadData() throws IOException;
}
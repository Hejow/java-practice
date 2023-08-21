module db {
    requires transitive service;
    requires java.logging;
    exports student.service.dbimpl;
}

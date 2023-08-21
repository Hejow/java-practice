package ETC.sealed;

public sealed interface Car permits Perari {
    void run();
}

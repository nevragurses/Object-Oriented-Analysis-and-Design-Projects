/**
 * Enum class for keeping content names.
 */
public enum Demands {
    Text, Photographs,Audio;

    /**
     * Getting content names.
     * @return content names.
     */
    public String toString() {
       switch (this){
           case Text: return "Text";
           case Photographs: return "Photograph";
           case Audio: return "Audio";
           default: return "Unspecified";

       }
    }
}

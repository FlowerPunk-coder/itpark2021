package exam.dto;


public class StreetDto {


    private long id;

    private String name;

    private DistrictDto districtDto;

    public StreetDto(String name, DistrictDto districtDto) {
        this.name = name;
        this.districtDto = districtDto;
    }

    public StreetDto() {
    }


    public String getName() {
        return this.name;
    }

    public DistrictDto getDistrictDto() {
        return this.districtDto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrictDto(DistrictDto districtDto) {
        this.districtDto = districtDto;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StreetDto)) return false;
        final StreetDto other = (StreetDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$districtDto = this.getDistrictDto();
        final Object other$districtDto = other.getDistrictDto();
        if (this$districtDto == null ? other$districtDto != null : !this$districtDto.equals(other$districtDto))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StreetDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $districtDto = this.getDistrictDto();
        result = result * PRIME + ($districtDto == null ? 43 : $districtDto.hashCode());
        return result;
    }

    public String toString() {
        return "StreetDto(name=" + this.getName() + ", districtDto=" + this.getDistrictDto() + ")";
    }
}

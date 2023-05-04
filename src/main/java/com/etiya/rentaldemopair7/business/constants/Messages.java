package com.etiya.rentaldemopair7.business.constants;

public class Messages {
    public static class Color{
        public static final String ColorExists="colorExists";
        public static final String ColorDoesNotExistsWithGivenId = "colorDoesNotExistsWithGivenId";

        public static final String ColorAdded= "colorAdded";

        public static final String ColorUpdated="colorUpdated";
        public static final String ColorDeleted="colorDeleted";

        public static final String CarWithColorIdShouldNotExist= "carWithColorIdShouldNotExist";
    }

    public static class Car{
        public static final String CarExists="carExists";

        public static final String CarAdded= "carAdded";

        public static final String CarUpdated="carUpdated";

        public static final String DataListed="dataListed";
    }

    public static class Accessory{
        public static final String AccessoryExists="accessoryExists";

        public static final String SuccessAddAccessory="successAddAccessory";

        public static final String AccessoryUpdated="accessoryUpdated";

        public static final String DataListed="dataListed";

        public static final String AccessoryDeleted="accessoryDeleted";

    }

    public static class Branch{

        public static final String BranchUpdated="branchUpdated";

        public static final String BranchExists="branchExists";

        public static final String SuccessAddBranch="successAddBranch";

    }

    public static class Brand{
        public static final String BrandUpdated="brandUpdated";

        public static final String BrandExists="brandExists";

        public static final String SuccessAddBrand="successAddBrand";

    }

    public static class Customer{

        public static final String CustomerExists="customerExists";

        public static final String SuccessAddCustomer="successAddCustomer";

        public static final String CustomerUpdated="customerUpdated";

    }

    public static class Rental{

        public static final String SuccessAddRental="successAddRental";

        public static final String RentalUpdated="rentalUpdated";

    }
}

var app = angular.module("myApp", []);
app.controller("myController", function ($scope, $http) {

    $scope.listSV = [];
    $scope.viTriUpdate = -1;

    $scope.request = {
        ten: "",
        tuoi:null,
        gioiTinh: true,
        chuyenNghanh: "udpm",
    };

    let url = "http://localhost:8080/api/sinh-vien";
    let api = url + "/hien-thi";

    hienThi();

    function hienThi() {
        //get data from server
        $http.get(api).then(function (respone) {

            $scope.listSV = respone.data;

        }), function (errors) {
            console.log(errors);
        }
    }

    // delete object sinhvien
    $scope.removeSinhVien = function (event, index) {

        event.preventDefault();

        let sv = $scope.listSV[index]; // get sv by index
        let api = url + "/delete/" + sv.id;

        // perform delete action
        $http.delete(api).then(function () {
            $scope.listSV.splice(index, 1);
            alert("xoa thanh cong");

        }), function (errors) {
            console.log(errors);
        }

    }

    


    // add
    $scope.addSV = function () {
        let api = url +"/add";
        $http.post(api, JSON.stringify($scope.request)).then(function () {
            hienThi();
            alert("them thanh cong");
        }), function (errors) {
            console.log(errors);
        }
    }

    // details
    $scope.details = function (event, index) {
        event.preventDefault();
        let sv = $scope.listSV[index];
        $scope.request.tuoi = new Date(sv.tuoi);
        $scope.request.ten = sv.ten;
        $scope.request.gioiTinh = sv.gioiTinh;
        $scope.request.chuyenNghanh = sv.chuyenNganh;
        $scope.viTriUpdate = index;
        console.log($scope.request.chuyenNghanh = sv.chuyenNghanh.toString())
    };
    

    //update use put

    $scope.updateSV = function () {
        if ($scope.viTriUpdate == -1) {
            alert("Please select the index to update");
        } else {
            let sv = $scope.listSV[$scope.viTriUpdate]; // get sv from vitriUpdate in listSV
            let api = url + "/update/" + sv.id;
            $http.put(api, JSON.stringify($scope.request)).then(function () {
                hienThi();
                alert("Update successFull");
            }), function (errors) {
                console.log(errors)
            }
        }
    }

});
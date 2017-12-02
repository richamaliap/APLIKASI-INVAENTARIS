<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class C_Barang extends CI_Controller {

    public function __construct() {
        parent::__Construct();
        $this->load->helper('string');
        $this->load->helper('date');
        $this->load->model('M_Barang');
    }

    public function index() {
        $this->load->view('Head/V_Header');
        $this->load->view('Head/V_Menu');
        $this->load->view('Head/V_Toggle');
        $result['query'] = $this->M_Barang->ShowBarang();
        if (filter_input(INPUT_POST, "submit")) {
            $Divisi = filter_input(INPUT_POST, "Divisi");
            if ($Divisi == 'IT Helpdesk') {
                $result['query'] = $this->M_Barang->ShowDivisi('IT Helpdesk');
            } else if ($Divisi == 'IT Internal') {
                $result['query'] = $this->M_Barang->ShowDivisi('IT Internal');
            }
        }
        $this->load->view('V_Home', $result);
        $this->load->view('Foot/V_Footer');
    }

    public function ShowBarang() {
        $this->load->view('Head/V_Header');
        $this->load->view('Head/V_MenuAdmin');
        $this->load->view('Head/V_Toggle');
        $result['query'] = $this->M_Barang->ShowBarang();
        if (filter_input(INPUT_POST, "submit")) {
            $Divisi = filter_input(INPUT_POST, "Divisi");
            if ($Divisi == 'IT Helpdesk') {
                $result['query'] = $this->M_Barang->ShowDivisi('IT Helpdesk');
            } else if ($Divisi == 'IT Internal') {
                $result['query'] = $this->M_Barang->ShowDivisi('IT Internal');
            } else {
                $result['query'] = $this->M_Barang->ShowBarang();
            }
        }
        $this->load->view('V_HomeAdmin', $result);
        $this->load->view('Foot/V_Footer');
    }

    public function ShowByLoc() {
        $this->load->view('Head/V_Header');
        $this->load->view('Head/V_Menu');
        $this->load->view('Head/V_ToggleLoc');
        $result['query'] = $this->M_Barang->ShowBarang();
        if (filter_input(INPUT_POST, "submit")) {
            $Lokasi = filter_input(INPUT_POST, "Lokasi");
            if ($Lokasi == 'Gudang 1') {
                $result['query'] = $this->M_Barang->ShowLokasi('Gudang 1');
            } else if ($Lokasi == 'Gudang 2') {
                $result['query'] = $this->M_Barang->ShowLokasi('Gudang 2');
            } else if ($Lokasi == 'Gudang 3') {
                $result['query'] = $this->M_Barang->ShowLokasi('Gudang 3');
            } else if ($Lokasi == 'Gudang 4') {
                $result['query'] = $this->M_Barang->ShowLokasi('Gudang 4');
            } else {
                $result['query'] = $this->M_Barang->ShowLokasi('Gudang 5');
            }
        }
        $this->load->view('V_Location', $result);
        $this->load->view('Foot/V_Footer');
    }

  
}

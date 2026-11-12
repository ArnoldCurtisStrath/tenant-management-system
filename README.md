# Tenant Management System

An Android app for landlords to record tenants, see the total rent, and call a tenant.

## Download

Latest APK: see **Releases** on the right of this page. Download `app-release.apk` and install it on your phone.

## Features

- Register and log in
- Dashboard with the number of tenants and the total rent
- Add tenants and view all of them
- Tenants are saved with Room, so they are still there after the app is closed
- Call a tenant straight from the app
- Options menu and navigation drawer

## Architecture

The code is split into a UI layer and a data layer. The UI layer may use the data layer, but the data layer never reaches up into the UI.

```
ui/
  auth/         LoginActivity, RegisterActivity
  main/         MainActivity
  dashboard/    DashboardFragment
  tenants/      AddTenantFragment, ViewTenantsFragment
  about/        AboutFragment
  viewmodel/    TenantViewModel
data/
  model/        Tenant
  local/        TenantDao, TenantDatabase
  repository/   TenantRepository
```

Screens → TenantViewModel (LiveData) → TenantRepository → Room

The `TenantViewModel` holds the list of tenants and turns it into the text the screens show. It never holds an Activity, a Fragment or a View, so it survives a rotation. The `TenantRepository` is the only door into the data layer, so the screens never talk to the database directly.

## Team

| Stage | Member | Admission No. | Pull request |
|---|---|---|---|
| 1 Lead | Arnold Wangai Mbici | 166569 | pushed straight to `main` |
| 2 ViewModel | Kabutha Joe Mwangi | 172896 | [#1](https://github.com/ArnoldCurtisStrath/tenant-management-system/pull/1) |
| 3 Room | Kwendo Andrew Abel | 192106 | [#2](https://github.com/ArnoldCurtisStrath/tenant-management-system/pull/2) |
| 4 Screens | Leon Onyancha Ouya | 189367 | [#3](https://github.com/ArnoldCurtisStrath/tenant-management-system/pull/3) |
| 5 Data integration | Lusiola Erika Wambui | 177886 | [#4](https://github.com/ArnoldCurtisStrath/tenant-management-system/pull/4) |
| 6 Release | Naaadir Abdulaziz Rana | 189548 | [#5](https://github.com/ArnoldCurtisStrath/tenant-management-system/pull/5) |

Each stage was done on its own branch and went into `main` through a pull request that another member reviewed.
